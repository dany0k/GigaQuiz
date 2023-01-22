package ru.vsu.cs.zmaev.model;


public class User {
    private int userID;
    private int countryID;
    private int resultID;
    private int questionID;
    private String name;
    private int age;
    private String sex;
    private String userIconName;

    public User(int userID, int countryID, int resultID, int questionID, String name, int age, String sex, String userIconName) {
        this.userID = userID;
        this.countryID = countryID;
        this.resultID = resultID;
        this.questionID = questionID;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.userIconName = userIconName;
    }

    public User() {
        userID = 1;
        resultID = 0;
        questionID = 0;
        userIconName = "ic_baseline_person_24";
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserIconName() {
        return userIconName;
    }

    public void setUserIconName(String userIconName) {
        this.userIconName = userIconName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", countryID=" + countryID +
                ", resultID=" + resultID +
                ", questionID=" + questionID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", userIconName='" + userIconName + '\'' +
                '}';
    }

}
