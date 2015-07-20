package com.example.kelly.logeasyresearch;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oanacozma on 04/04/15.
 */
public class ClassScoreboard implements Parcelable{
    private long user_id;
    private int points;
    private int wrong_number;
    private int level_id;

    public ClassScoreboard(){
        user_id=0;
        points=0;
        wrong_number=0;
        level_id=0;
    }

    public ClassScoreboard(Parcel in){
        readFromParcel(in);
    }

    public ClassScoreboard(long user, int no_of_points, int wro_number, int level){
        user_id= user;
        points= no_of_points;
        wrong_number= wro_number;
        level_id=level;
    }

    public long getUser_id() {
        return this.user_id;
    }

    public int getPoints() {
        return this.points;
    }

    public int getWrong_number() {
        return this.wrong_number;
    }

    public int getLevel_id() {
        return this.level_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setWrong_number(int wro_number) {
        this.wrong_number = wro_number;
    }

    public void setLevel_id(int level_id) {
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
        out.writeInt(level_id);
    }

    private void readFromParcel(Parcel in) {
        user_id = in.readLong();
        points = in.readInt();
        wrong_number = in.readInt();
        level_id = in.readInt();
    }

    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {
        public ClassScoreboard createFromParcel(Parcel in) {
            return new ClassScoreboard(in);
        }

        public ClassScoreboard[] newArray(int size) {
            ClassUser user2;
            return new ClassScoreboard[size];
        }
    };
}
