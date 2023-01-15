package ru.vsu.cs.zmaev.model;

public class User {

    private String name;
    private int age;
    private int progress;
    private int iconID;
    private String country;
    private String sex;
    private float android_result;
    private float geographical_result;


    public User(String name, int age, int progress, int iconID, String country, String sex, float android_result, float geographical_result) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.iconID = iconID;
        this.country = country;
        this.sex = sex;
        this.android_result = android_result;
        this.geographical_result = geographical_result;
    }

    public User(String name, int age, int progress, String country, String sex, float android_result, float geographical_result) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.country = country;
        this.sex = sex;
        this.android_result = android_result;
        this.geographical_result = geographical_result;
    }

    public float getAndroid_result() {
        return android_result;
    }

    public void setAndroid_result(float android_result) {
        this.android_result = android_result;
    }

    public float getGeographical_result() {
        return geographical_result;
    }

    public void setGeographical_result(float geographical_result) {
        this.geographical_result = geographical_result;
    }

    public User(String name, int age, int progress, String country, String sex) {
        this.name = name;
        this.age = age;
        this.progress = progress;
        this.country = country;
        this.sex = sex;

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
}
