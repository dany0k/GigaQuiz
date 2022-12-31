package ru.vsu.cs.zmaev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;

public class GameFragment extends Fragment {
    static class Question {
        String text;
        ArrayList<String> answers;

        public Question(String text, ArrayList<String> answers) {
            this.text = text;
            this.answers = answers;
        }
    }

    private static ArrayList<Question> getQuestionsBank() {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<String> answer1 = new ArrayList<>();
        Collections.addAll(answer1, "Yes!", "No!");
        questions.add(new Question("Are u gay?", answer1));
        return questions;
    }
}