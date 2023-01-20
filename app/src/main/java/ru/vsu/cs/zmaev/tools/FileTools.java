package ru.vsu.cs.zmaev.tools;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import ru.vsu.cs.zmaev.model.ImageQuestion;

public class FileTools {

    public static boolean isFilePresent(Context context, String fileName) {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

    public static void clearMyFiles(Context context) {
        File[] files = context.getFilesDir().listFiles();
        if(files != null)
            for(File file : files) {
                file.delete();
            }
    }

    public static List<String> readFilesInList(Context context, String path) {
        String [] list;
        List<String> outList = new ArrayList<>();
        try {
            list = context.getAssets().list(path);
            String regex = ".*questions$";
            Pattern pattern = Pattern.compile(regex);
            if (list.length > 0) {
                for (String file : list) {
                    if (pattern.matcher(file).matches()) {
                        outList.add(file);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public static List<ImageQuestion> parseQuestionsFromTxt(Context context, String fileName) throws IOException, URISyntaxException {
        String str;
        List<ImageQuestion> questionsBank = new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str = new String(buffer);
            String[] splitRow = str.split("\n");
            String questionName;
            String questionAnswers;
            String questionImageName;
            for (int i = 0; i < splitRow.length; i++) {
                String[] splitQuestions = splitRow[i].split("\n");
                for (int j = 0; j < splitQuestions.length; j++) {
                    String[] splitQuestion = splitQuestions[j].split(":");
                    questionName = splitQuestion[0];
                    questionAnswers = splitQuestion[1];
                    questionImageName = splitQuestion[2].trim();
                    int imageID = context.getResources().getIdentifier(questionImageName, "drawable", context.getPackageName());
                    System.out.println(imageID);
                    String[] answers = questionAnswers.split(";");
                    ImageQuestion question = new ImageQuestion(questionName, Arrays.asList(answers), imageID);
                    questionsBank.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionsBank;
    }
}
