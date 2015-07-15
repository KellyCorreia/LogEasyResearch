package com.example.kelly.logeasyresearch;


import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LessonActivity extends FragmentActivity {
    TextView txtPoints;
    Button btnPlay, btnLevels;
    RelativeLayout layout;
    LinearLayout firstLayout;
    LevelClass selecLevel;
    ImageView ImgAvatar;
    Random rd = new Random();

    UserClass User;
    ScoreboardClass Score;

    List <QuestionClass> q = new ArrayList<>();
    MySQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        bd = new MySQLiteHelper(this);

        Bundle extras = getIntent().getExtras();
        User = extras.getParcelable("chosenUser");
        selecLevel =extras.getParcelable("chosenLevel");
        Score =extras.getParcelable("userScore");

        q = bd.levelQuestion(selecLevel.getLevel_id());
        txtPoints = (TextView)findViewById(R.id.txtPoints);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        btnLevels=(Button)findViewById(R.id.btnLevels);
        layout = (RelativeLayout)findViewById(R.id.relativeLayoutLesson);
        firstLayout = (LinearLayout)findViewById(R.id.linearLayoutFirst);
        ImgAvatar = (ImageView)findViewById(R.id.imageViewAvatar);


        this.setLesson();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getCallingActivity() == null) {
                    Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
                    intent.putExtra("chosenUser", User);
                    intent.putExtra("chosenLevel", selecLevel);
                    intent.putExtra("userScore", Score);
                    startActivity(intent);
                    finish();
                }else{
                    finish();
                }
            }
        });

        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Calling the lesson  fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SlidingLessonFragment fragment = new SlidingLessonFragment();
        fragment.setArguments(extras);
        transaction.replace(R.id.sample_content_fragmentlesson, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    private void setLesson(){ //Method to take the lesson from the Level Class and from the User Class
        txtPoints.setText(Integer.toString(Score.getPoints()));
        firstLayout.setBackgroundColor(Color.parseColor("#FF192030"));


        switch (User.getAvatar()) {
            case "Avatar1":
                int random = rd.nextInt(4);
                if (random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar12);
                else {
                    if (random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar13);
                    else {
                        if (random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar14);
                        else {
                            ImgAvatar.setImageResource(R.drawable.avatar15);
                        }
                    }
                }
                break;

            case "Avatar2":
                random = rd.nextInt(4);
                if (random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar22);
                else {
                    if (random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar23);
                    else {
                        if (random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar24);
                        else {
                            ImgAvatar.setImageResource(R.drawable.avatar25);
                        }
                    }
                }
                break;

            case "Avatar3":
                random = rd.nextInt(4);
                if (random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar32);
                else {
                    if (random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar33);
                    else {
                        if (random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar34);
                        else {
                            ImgAvatar.setImageResource(R.drawable.avatar35);
                        }
                    }
                }
                break;

            case "Avatar4":
                random = rd.nextInt(4);
                if (random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar42);
                else {
                    if (random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar43);
                    else {
                        if (random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar44);
                        else {
                            ImgAvatar.setImageResource(R.drawable.avatar45);
                        }
                    }
                }
                break;
        }

        switch(selecLevel.getLevel_id()){
            case "L01":
                layout.setBackgroundResource(R.drawable.backgroundlevel1);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel);
                break;
            case "L02":
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel2);
                break;
            case "L03":
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel3);
                break;
            case "L04":
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel4);
                break;
            case "L05":
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel5);
                break;
            case "L06":
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel6);
                break;
            case "L07":
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel7);
                break;
            case "L08":
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel8);
                break;
            case "L09":
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel9);
                break;
            case "L10":
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                btnPlay.setBackgroundResource(R.drawable.buttomlevel10);
                break;
        }

    }

    public String getCurrentClass() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfo = manager.getRunningTasks(1);

        ComponentName componentInfo = runningTaskInfo.get(0).topActivity;
        String className = componentInfo.getClassName();
        return className;
    }

}
