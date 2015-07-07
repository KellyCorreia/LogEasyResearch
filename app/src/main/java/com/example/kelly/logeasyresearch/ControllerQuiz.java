package com.example.kelly.logeasyresearch;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hiyori on 14/04/15.
 */
public class ControllerQuiz implements Parcelable{


    private String user;
    private String levelName;
    private String levelChosen;
    public ControllerQuiz() {
        this.levelChosen="0";
        this.levelName="0";
        this.user="1";
    }
    public ControllerQuiz(String userid, String lvlchosen, String lvlname) {
        this.levelChosen=lvlchosen;
        this.levelName=lvlname;
        this.user=userid;
    }

    public ControllerQuiz(Parcel in) {
        readFromParcel(in);
    }

    public String getUser() {
        return user;
    }
    public String getLevelName() {
        return levelName;
    }
    public String getLevelChosen() {
        return levelChosen;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(user);
        out.writeString(levelName);
        out.writeString(levelChosen);
    }
    private void readFromParcel(Parcel in) {

        user = in.readString();
        levelName = in.readString();
        levelChosen = in.readString();
    }
    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {
        public ControllerQuiz createFromParcel(Parcel in) {
            return new ControllerQuiz(in);
        }

        public ControllerQuiz[] newArray(int size) {
            return new ControllerQuiz[size];
        }
    };
}
