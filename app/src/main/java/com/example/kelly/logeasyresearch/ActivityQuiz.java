package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ActivityQuiz extends Activity {

    List<ClassQuestion> qList = new ArrayList<>();
    List<ClassAnswer> aList = new ArrayList<>();

    TextView txtQuest, txtPoints;
    RadioGroup grp;
    RadioButton rda, rdb, rdc;
    Button butNext, btnLesson, btnHint,btnLevelsQ;
    RelativeLayout layout;
    RadioButton rightAnswer,userAnswer;
    ClassScoreboard Score;

    ClassUser User;
    ClassLevel selecLevel;
    Intent intent = new Intent();
    MySQLiteHelper db;

    int score, wScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        db = new MySQLiteHelper(this);

        Bundle extras = getIntent().getExtras();
        User = extras.getParcelable("chosenUser");
        selecLevel = extras.getParcelable("chosenLevel");

        Score = db.getScore(User.getUser_id());

        score = Score.getPoints();
        wScore = Score.getWrong_number();

        txtPoints = (TextView)findViewById(R.id.txtPoints);
        txtQuest =(TextView)findViewById(R.id.txtQuestion);
        grp=(RadioGroup)findViewById(R.id.radioGroupAnswers);
        rda=(RadioButton)findViewById(R.id.radioA);
        rdb=(RadioButton)findViewById(R.id.radioB);
        rdc=(RadioButton)findViewById(R.id.radioC);
        butNext=(Button)findViewById(R.id.btnNext);
        btnHint = (Button)findViewById(R.id.btnHint);
        btnLesson = (Button)findViewById(R.id.btnLesson);
        btnLevelsQ = (Button)findViewById(R.id.btnLevelsQ);
        layout = (RelativeLayout)findViewById(R.id.layoutQuiz);

        setQuestionView();

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((rda.isChecked()) || (rdb.isChecked())||(rdc.isChecked())) {

                    userAnswer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

                    if (userAnswer == rightAnswer) {
                        Toast.makeText(ActivityQuiz.this, "Right Answer!", Toast.LENGTH_SHORT).show();

                        if ( selecLevel.getLevel_id() == Score.getLevel_id() ) {
                            score += 10;
                            setScoreBoard();
                        }
                        else{
                            setQuestionView();
                        }
                    }else {
                        Toast.makeText(ActivityQuiz.this, "Wrong answer!", Toast.LENGTH_SHORT).show();
                        setQuestionView();
                        wScore += 1;
                        db.updatingWrongScore(wScore,User);
                    }
                    grp.clearCheck();

                }else{
                    Toast.makeText(ActivityQuiz.this, "Select one option!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ActivityQuiz.this, ActivityHint.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userScore", Score);
                startActivity(intent);
            }
        });

        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ActivityQuiz.this, ActivityLesson.class);
                intent.putExtra("chosenUser", User);
                intent.putExtra("chosenLevel", selecLevel);
                intent.putExtra("userScore", Score);
                startActivityForResult(intent,0);
            }
        });
        btnLevelsQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void setQuestionView(){

        if(qList.size() == 0) {
            qList = db.levelQuestion(selecLevel.getLevel_id());
        }

        aList = db.getAnswer(qList.get(0).getQuestion_id());
        String backBaseName = "backgroundlevel";
        layout.setBackgroundResource(getResources().getIdentifier(backBaseName+String.valueOf(selecLevel.getLevel_id()),"drawable", this.getPackageName()));

        txtPoints.setText(Integer.toString(Score.getPoints()));
        txtQuest.setText(qList.get(0).getQuestion_text());
        rda.setText(aList.get(0).getAnswer_text());
        rdb.setText(aList.get(1).getAnswer_text());
        rdc.setText(aList.get(2).getAnswer_text());

        if(aList.get(0).getAnswer_state() == 1) {
            rightAnswer = rda;
        }else {
            if (aList.get(1).getAnswer_state() == 1) {
                rightAnswer = rdb;
            } else {
                rightAnswer = rdc;
            }
        }
        qList.remove(0);


        score = Score.getPoints();
        wScore = Score.getWrong_number();
    }

    private void setScoreBoard(){

        intent.setClass(ActivityQuiz.this, ActivityLesson.class);

        if( (score==(selecLevel.getLevel_id()*50))&&(score<= 500)){
            db.updatingScore(score, User, selecLevel.getLevel_id()+1);
            selecLevel = db.getLevel( selecLevel.getLevel_id()+1);
            Score = db.getScore(User.getUser_id());
            intent.putExtra("chosenUser", User);
            intent.putExtra("chosenLevel", selecLevel);
            intent.putExtra("userScore", Score);

            if( selecLevel.getLevelname().equals("Dark City") )
                Toast.makeText(ActivityQuiz.this, "Congratulations! You master the "+selecLevel.getLevelname()+" element!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(ActivityQuiz.this, "You defeated the "+selecLevel.getLevelname()+" !", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();

        }else{
            db.updatingScore(score, User, Score.getLevel_id());
            Score = db.getScore(User.getUser_id());
            setQuestionView();
        }
    }
}