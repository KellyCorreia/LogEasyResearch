package com.example.kelly.logeasyresearch;

/**
 * Created by Kelly on 15/04/2015.
 */
public class ScoreboardScreen {
    private String userName;
    private String levelName;
    private int points;
    private double wrongPerc;

    public ScoreboardScreen() {
        this.userName = "";
        this.levelName = "";
        this.points = 0;
        this.wrongPerc = 0.0;
    }

    public ScoreboardScreen(String userName, String levelName, int points, double wrongPerc) {
        this.userName = userName;
        this.levelName = levelName;
        this.points = points;
        this.wrongPerc = wrongPerc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getWrongPerc() {
        return wrongPerc;
    }

    public void setWrongPerc(double wrongPerc) {
        this.wrongPerc = wrongPerc;
    }
}
