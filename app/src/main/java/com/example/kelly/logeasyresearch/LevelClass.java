package com.example.kelly.logeasyresearch;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oanacozma on 04/04/15.
 */
public class LevelClass implements Parcelable {

    private String level_id;
    private String levelname;
    private String lesson;
    private String tip;



    public LevelClass(){
        level_id="";
        levelname="";
        lesson="";
        tip="";

    }
    public LevelClass(Parcel in) {
        readFromParcel(in);
    }

    public LevelClass(String l_id, String l_name, String l_lesson, String l_tip){
        level_id=l_id;
        levelname=l_name;
        lesson=l_lesson;
        tip=l_tip;
    }

    public String getLevelname() {
        return levelname;
    }

    public String getLevel_id() {
        return level_id;
    }

    public String getLesson() {
        return lesson;
    }

    public String getTip() {
        return tip;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(level_id);
        out.writeString(levelname);
        out.writeString(lesson);
        out.writeString(tip);
    }

    private void readFromParcel(Parcel in) {
        level_id = in.readString();
        levelname = in.readString();
        lesson = in.readString();
        tip = in.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {
        public LevelClass createFromParcel(Parcel in) {
            return new LevelClass(in);
        }

        public LevelClass[] newArray(int size) {
            return new LevelClass[size];
        }
    };
}
