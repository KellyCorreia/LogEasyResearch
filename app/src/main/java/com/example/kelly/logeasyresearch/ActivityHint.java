package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;


public class ActivityHint extends Activity {
    TextView txtPoints;
    Button btnPlay;
    ImageView ImgAvatar;
    ImageView ImgHint;
    RelativeLayout layout;
    LinearLayout firstLayout;
    ClassUser user;
    ClassScoreboard score;
    ClassLevel seleclevel;
    Random rd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        Bundle extras = getIntent().getExtras();
        user = (ClassUser)extras.getParcelable("chosenUser");
        seleclevel = (ClassLevel)extras.getParcelable("chosenLevel");
        score = (ClassScoreboard)extras.getParcelable("userScore");

        txtPoints = (TextView)findViewById(R.id.txtPoints);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        ImgAvatar = (ImageView)findViewById(R.id.imgAvatarHint);
        ImgHint = (ImageView)findViewById(R.id.ivwHInt);
        layout = (RelativeLayout)findViewById(R.id.layoutHint);
        firstLayout = (LinearLayout)findViewById(R.id.layoutHintMiddle);

        setHintView();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setHintView(){
        MySQLiteHelper db = new MySQLiteHelper(this);

        txtPoints.setText(Integer.toString(score.getPoints()));

        switch (user.getAvatar()){
            case "Avatar1":
                int random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar12);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar13);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar14);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar15);
                        }
                    }
                }
                break;

            case "Avatar2":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar22);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar23);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar24);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar25);
                        }
                    }
                }
                break;

            case "Avatar3":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar32);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar33);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar34);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar35);
                        }
                    }
                }
                break;

            case "Avatar4":
                random = rd.nextInt(4);
                if(random == 0)
                    ImgAvatar.setImageResource(R.drawable.avatar42);
                else{
                    if(random == 1)
                        ImgAvatar.setImageResource(R.drawable.avatar43);
                    else{
                        if(random == 2)
                            ImgAvatar.setImageResource(R.drawable.avatar44);
                        else{
                            ImgAvatar.setImageResource(R.drawable.avatar45);
                        }
                    }
                }
                break;
        }

        switch(seleclevel.getLevel_id()){
            case 1:
                layout.setBackgroundResource(R.drawable.backgroundlevel1);
                btnPlay.setBackgroundResource(R.drawable.buttomhin1);
                ImgHint.setImageResource(R.drawable.level1hint);
                break;
            case 2:
                layout.setBackgroundResource(R.drawable.backgroundlevel2);
                btnPlay.setBackgroundResource(R.drawable.buttomhin2);
                ImgHint.setImageResource(R.drawable.level2hint);
                break;
            case 3:
                layout.setBackgroundResource(R.drawable.backgroundlevel3);
                btnPlay.setBackgroundResource(R.drawable.buttomhin3);
                ImgHint.setImageResource(R.drawable.level3hint);
                break;
            case 4:
                layout.setBackgroundResource(R.drawable.backgroundlevel4);
                btnPlay.setBackgroundResource(R.drawable.buttomhin4);
                ImgHint.setImageResource(R.drawable.level4hint);
                break;
            case 5:
                layout.setBackgroundResource(R.drawable.backgroundlevel5);
                btnPlay.setBackgroundResource(R.drawable.buttomhin5);
                ImgHint.setImageResource(R.drawable.level5hint);
                break;
            case 6:
                layout.setBackgroundResource(R.drawable.backgroundlevel6);
                btnPlay.setBackgroundResource(R.drawable.buttomhin6);
                ImgHint.setImageResource(R.drawable.level6hint);
                break;
            case 7:
                layout.setBackgroundResource(R.drawable.backgroundlevel7);
                btnPlay.setBackgroundResource(R.drawable.buttomhin7);
                ImgHint.setImageResource(R.drawable.level7hint);
                break;
            case 8:
                layout.setBackgroundResource(R.drawable.backgroundlevel8);
                btnPlay.setBackgroundResource(R.drawable.buttomhin8);
                ImgHint.setImageResource(R.drawable.level8hint);
            case 9:
                layout.setBackgroundResource(R.drawable.backgroundlevel9);
                btnPlay.setBackgroundResource(R.drawable.buttomhin9);
                ImgHint.setImageResource(R.drawable.level9hint);
                break;
            case 10:
                layout.setBackgroundResource(R.drawable.backgroundlevel10);
                btnPlay.setBackgroundResource(R.drawable.buttomhin10);
                ImgHint.setImageResource(R.drawable.level10hint);
                break;
        }



    }
}
