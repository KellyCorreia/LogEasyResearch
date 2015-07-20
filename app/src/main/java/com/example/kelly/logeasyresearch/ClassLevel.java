package com.example.kelly.logeasyresearch;

import android.os.Parcel;
import android.os.Parcelable;

public class ClassLevel implements Parcelable {

    private int level_id;
    private String levelName;
    private String lesson;
    private String tip;

    public ClassLevel(){
        level_id = 0;
        levelName="";
        lesson="";
        tip="";

    }
    public ClassLevel(Parcel in) {
        readFromParcel(in);
    }

    public ClassLevel(int l_id, String l_name, String l_lesson, String l_tip){
        level_id=l_id;
        levelName=l_name;
        lesson=l_lesson;
        tip=l_tip;
    }

    public String getLevelname() {
        return levelName;
    }

    public int getLevel_id() {
        return level_id;
    }

    public String getLesson() {
        return lesson;
    }

    public String getTip() {
        return tip;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public void setLevelname(String levelname) {
        this.levelName = levelname;
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
        out.writeInt(level_id);
        out.writeString(levelName);
        out.writeString(lesson);
        out.writeString(tip);
    }

    private void readFromParcel(Parcel in) {
        level_id = in.readInt();
        levelName = in.readString();
        lesson = in.readString();
        tip = in.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {
        public ClassLevel createFromParcel(Parcel in) {
            return new ClassLevel(in);
        }
        public ClassLevel[] newArray(int size) {
            return new ClassLevel[size];
        }
    };
}
