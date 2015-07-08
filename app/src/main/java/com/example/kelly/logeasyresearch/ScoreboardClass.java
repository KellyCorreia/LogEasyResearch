package com.example.kelly.logeasyresearch;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oanacozma on 04/04/15.
 */
public class ScoreboardClass implements Parcelable{
    private long user_id;
    private int points;
    private int wrong_number;
    private String level_id;

    public ScoreboardClass(){
        user_id=0;
        points=0;
        wrong_number=0;
        level_id="";
    }

    public ScoreboardClass(Parcel in){
        readFromParcel(in);
    }

    public ScoreboardClass(long user, int no_of_points, int percent_wrong, String level){
        user_id=user;
        points=no_of_points;
        wrong_number=percent_wrong;
        level_id=level;
    }

    public long getUser_id() {
        return user_id;
    }

    public int getPoints() {
        return points;
    }

    public int getWrong_number() {
        return wrong_number;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setWrong_number(int wrong_number) {
        this.wrong_number = wrong_number;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(user_id);
        out.writeInt(points);
        out.writeInt(wrong_number);
        out.writeString(level_id);
    }

    private void readFromParcel(Parcel in) {
        user_id = in.readLong();
        points = in.readInt();
        wrong_number = in.readInt();
        level_id = in.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {
        public ScoreboardClass createFromParcel(Parcel in) {
            return new ScoreboardClass(in);
        }

        public ScoreboardClass[] newArray(int size) {
            UserClass user2;
            return new ScoreboardClass[size];
        }
    };
}
