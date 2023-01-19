package ru.vsu.cs.zmaev.model;

import org.json.JSONException;
import org.json.JSONObject;


public class User {

    private String name;
    private int age;
    private int progress;
    private int iconID;
    private String country;
    private String sex;
    private float androidResult;
    private float geographicalResult;
    public User() {
    }

    public User(String name, int age, int progress, int iconID, String country, String sex, float androidResult, float geographicalResult) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.iconID = iconID;
        this.country = country;
        this.sex = sex;
        this.androidResult = androidResult;
        this.geographicalResult = geographicalResult;
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

    public float getAndroidResult() {
        return androidResult;
    }

    public void setAndroidResult(float androidResult) {
        this.androidResult = androidResult;
    }

    public float getGeographicalResult() {
        return geographicalResult;
    }

    public void setGeographicalResult(float geographicalResult) {
        this.geographicalResult = geographicalResult;
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
            userJSON.put("androidResult", androidResult);
            userJSON.put("geographicalResult", geographicalResult);
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
                ", androidResult=" + androidResult +
                ", geographicalResult=" + geographicalResult +
                '}';
    }
}
