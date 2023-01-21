package ru.vsu.cs.zmaev.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;


public class User {

    private String name;
    private int age;
    private int progress;
    private int iconID;
    private String country;
    private String sex;
    private String topics;
    private String results;
    public User() {
    }

    public User(String name, int age, int progress, int iconID, String country, String sex, String topics, String results) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.iconID = iconID;
        this.country = country;
        this.sex = sex;
        this.topics = topics;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public JSONObject toJson() {
        JSONObject userJSON = new JSONObject();
        try {
            userJSON.put("name", name);
            userJSON.put("age", age);
            userJSON.put("progress", progress);
            userJSON.put("iconID", iconID);
            userJSON.put("country", country);
            userJSON.put("sex", sex);
            userJSON.put("topics", new Gson().toJson(topics).replaceAll("\\\\", ""));
            userJSON.put("results", new Gson().toJson(results));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userJSON;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", progress=" + progress +
                ", iconID=" + iconID +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", topics=" + topics +
                ", results=" + results +
                '}';
    }
}
