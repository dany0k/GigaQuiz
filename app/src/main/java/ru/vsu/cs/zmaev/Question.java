package ru.vsu.cs.zmaev;

import java.util.List;

public class Question {
    private final String text;
    private final List<String> answers;

    public Question(String text, List<String> answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
