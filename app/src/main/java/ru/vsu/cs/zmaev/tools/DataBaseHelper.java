package ru.vsu.cs.zmaev.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.model.User;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gigaquiz.db";

    private static final int FIRST_COL = 0;
    private static final int SECOND_COL = 1;
    private static final int THIRD_COL = 2;
    private static final int FOURTH_COL = 3;
    private static final int FIVE_COL = 4;
    private static final int SIX_COL = 5;
    private static final int SEVEN_COL = 6;

    private static final String USER_TABLE_NAME = "user";
    private static final String USER_ID = "user_id";
    private static final String RESULT_TABLE_NAME = "result";
    private static final String TOPIC_ID = "topic_id";
    private static final String EQUALS = " = ";
    private static final String COUNTRY_ID = "country_id";
    private static final String RESULT_ID = "result_id";
    private static final String QUESTION_ID = "question_id";
    private static final String USER_NAME_TEXT = "name";
    private static final String USER_AGE_TEXT = "age";
    private static final String USER_SEX_TEXT = "sex";
    private static final String USER_ICON_NAME_TEXT = "user_icon_name";
    private static final String USER_PERCENTAGE_TEXT = "percentage";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DataBaseTools.createDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String[] getTopics() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] topics = new String[4];
        Cursor query = db.rawQuery("SELECT topic_name FROM topic;", null);
        for (int i = 0; i < topics.length && query.moveToNext(); i++) {
            topics[i] = query.getString(FIRST_COL);
        }
        query.close();
        return topics;
    }

    public boolean isUserExists() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        return !query.moveToFirst();
    }

    public List<ImageQuestion> getQuestionsBank(Context context, int topicID) {
        SQLiteDatabase db = this.getWritableDatabase();
        List<ImageQuestion> questionsBank = new ArrayList<>();
        String questionQuery =
                "SELECT question_id, question_text, icon_name FROM question WHERE topic_id = ?";
        Cursor questionCursor = db.rawQuery(questionQuery, new String[] {String.valueOf(topicID)});
        String questionID;
        String questionText;
        String iconName;
        int iconID;
        List<String> answers;
        while (questionCursor.moveToNext()) {
            questionID = questionCursor.getString(FIRST_COL);
            questionText = questionCursor.getString(SECOND_COL);
            iconName = questionCursor.getString(THIRD_COL);
            iconID = context.getResources().getIdentifier(
                    iconName, "drawable", context.getPackageName());
            String answersQuery = "SELECT first_answer, second_answer, third_answer, fourth_answer" +
                    " FROM answer WHERE topic_id = ? AND question_id = ?";
            Cursor answersCursor = db.rawQuery(answersQuery, new String[] {String.valueOf(topicID),
                    questionID});
            while (answersCursor.moveToNext()) {
                String firstAnswer = answersCursor.getString(FIRST_COL);
                String secondAnswer = answersCursor.getString(SECOND_COL);
                String thirdAnswer = answersCursor.getString(THIRD_COL);
                String fourthAnswer = answersCursor.getString(FOURTH_COL);
                answers = Arrays.asList(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
                ImageQuestion question = new ImageQuestion(questionText, answers, iconID);
                questionsBank.add(question);
            }
            answersCursor.close();
        }
        questionCursor.close();
        return questionsBank;
    }

    private String showResults() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT topic_name, percentage FROM topic" +
                " INNER JOIN result ON topic.topic_id == result.topic_id;", null);
        StringBuilder stringBuilder = new StringBuilder();
        while (query.moveToNext()) {
            stringBuilder.append(query.getString(FIRST_COL))
                         .append(": ")
                         .append(query.getString(SECOND_COL))
                         .append("%\n");
        }
        query.close();
        return stringBuilder.toString();
    }

    public void showProfile(Context context, TextView profileUsername, TextView result, ImageView countryIcon) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (query.moveToFirst()) {
            profileUsername.setText(query.getString(FIVE_COL));
        }
        result.setText(showResults());
        query = db.rawQuery("SELECT country_icon_name FROM country" +
                " INNER JOIN user ON country.country_id == user.country_id", null);
        if (query.moveToFirst()) {
            int countryIconID = context.getResources().getIdentifier(
                    query.getString(FIRST_COL), "drawable", context.getPackageName());
            countryIcon.setImageResource(countryIconID);
        }
        query.close();
    }

    public void addResult(int topicID, int percentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String query = "SELECT percentage FROM result WHERE topic_id = ?;";
        Cursor cursor = db.rawQuery(query, new String[] {String.valueOf(topicID)});
        if (cursor.moveToFirst()) {
            int prevPercentage = Integer.parseInt(cursor.getString(FIRST_COL));
            if (prevPercentage > percentage) {
                return;
            }
            contentValues.put("percentage", percentage);
            db.update(RESULT_TABLE_NAME, contentValues, TOPIC_ID + EQUALS + topicID, null);
            cursor.close();
            contentValues.clear();
        }
    }

    private static void addResults(SQLiteDatabase db, int userID) {
        ContentValues contentValues = new ContentValues();
        Cursor queryTopic = db.rawQuery("SELECT * FROM topic;", null);
        int defaultPercentage = 0;
        while (queryTopic.moveToNext()) {
            contentValues.put(TOPIC_ID, queryTopic.getString(FIRST_COL));
            contentValues.put(USER_ID, userID);
            contentValues.put(USER_PERCENTAGE_TEXT, defaultPercentage);
            db.insert(RESULT_TABLE_NAME, null, contentValues);
            queryTopic.close();
            contentValues.clear();
        }
    }

    public String[] selectUser() {
        int resSize = 4;
        String[] res = new String[resSize];
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM user;", null);
        if (query.moveToFirst()) {
            res[0] = query.getString(FIVE_COL);
            res[1] = query.getString(SECOND_COL);
            res[2] = query.getString(SEVEN_COL);
            res[3] = query.getString(SIX_COL);
        }
        query.close();
        return res;
    }

    public boolean insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        System.out.println(user.toString());
        contentValues.put(COUNTRY_ID, user.getCountryID());
        contentValues.put(RESULT_ID, user.getResultID());
        contentValues.put(QUESTION_ID, user.getQuestionID());
        contentValues.put(USER_NAME_TEXT, user.getName());
        contentValues.put(USER_AGE_TEXT, user.getAge());
        contentValues.put(USER_SEX_TEXT, user.getSex());
        contentValues.put(USER_ICON_NAME_TEXT, user.getUserIconName());
        long result = db.insert(USER_TABLE_NAME, null, contentValues);
        addResults(db, user.getUserID());
        return result != -1;
    }

    public boolean updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_NAME_TEXT, user.getName());
        contentValues.put(USER_AGE_TEXT, user.getAge());
        contentValues.put(USER_SEX_TEXT, user.getSex());
        contentValues.put(COUNTRY_ID, user.getCountryID());

        long result = db.update(USER_TABLE_NAME, contentValues,
                USER_ID + EQUALS + user.getUserID(), null);
        return result != 1;
    }
}
