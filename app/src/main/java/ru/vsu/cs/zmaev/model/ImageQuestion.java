package ru.vsu.cs.zmaev.model;

import java.util.List;

public class ImageQuestion {
    private final String text;
    private final List<String> answers;
    private final int drawable_id;

    public ImageQuestion(String text, List<String> answers, int drawable_id) {
        this.text = text;
        this.answers = answers;
        this.drawable_id = drawable_id;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getDrawable_id() {
        return drawable_id;
    }
}
