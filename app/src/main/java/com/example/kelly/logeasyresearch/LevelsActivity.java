package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LevelsActivity extends Activity {

    private UserClass user;
    private ScoreboardClass userScore;
    private LevelClass chosenLevel;
    private int pointsU;
    MySQLiteHelper db;
    Intent intent = new Intent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //Getting the object user from the previous screen
        Bundle extras = getIntent().getExtras();
        user = extras.getParcelable("chosenUser");


        setlevelView();
        Button btnLevels;

        btnLevels = (Button)findViewById(R.id.imbLevel1);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIntent("L01");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel2);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (enoughPoints(1))
                    setToast("1 of Wind");
                else
                    setIntent("L02");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel3);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(2)) {
                    setToast("2 of Sound");
                }else
                    setIntent("L03");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel4);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(3))
                    setToast("3 of Metal");
                else
                    setIntent("L04");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel5);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(4))
                    setToast("4 of Sand");
                else
                    setIntent("L05");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel6);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(5))
                    setToast("5 of Snow");
                else
                    setIntent("L06");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel7);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(6))
                    setToast("6 of Plant");
                else
                    setIntent("L07");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel8);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(7))
                    setToast("7 of Lightning");
                else
                    setIntent("L08");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel9);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(8))
                    setToast("8 of Lava");
                else
                    setIntent("L09");
            }
        });

        btnLevels = (Button)findViewById(R.id.imbLevel10);
        btnLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enoughPoints(9))
                    setToast("9 of Dark City");
                else
                    setIntent("L010");
            }
        });

        Button btnScore = (Button) findViewById(R.id.btnScoreboard);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, Scoreboard_Activity.class);
                startActivity(intent);
            }
        });

        Button btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(LevelsActivity.this).create();
                alertDialog.setTitle("Log Out");
                alertDialog.setMessage("Proceed with Log Out?");
                alertDialog.setButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        });


        //welcome to the user
        Toast.makeText(LevelsActivity.this, "Welcome, " + user.getUsername()+" !", Toast.LENGTH_SHORT).show();
        Toast.makeText(LevelsActivity.this, "Choose a Level to start the challenge!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setIntent(String chosenLevelID){
        chosenLevel = db.getLevel(chosenLevelID);



      if(db.lessonStart(chosenLevelID, user.getUser_id())) {
          intent = new Intent(LevelsActivity.this, QuizActivity.class);
      }else {
          intent = new Intent(LevelsActivity.this, LessonActivity.class);
      }
        intent.putExtra("chosenUser", user);
        intent.putExtra("chosenLevel", chosenLevel);
        intent.putExtra("userScore", userScore);
        startActivity(intent);



    }
    public void setToast(String levelBefore){
        Toast.makeText(LevelsActivity.this, "Sorry, but you don't have enough points to access this level!  Answer more question in the levels before!", Toast.LENGTH_SHORT).show();
    }

    public boolean enoughPoints(int level){
        int valor = (level*50);

        if (pointsU>=valor)
            return false;
        else
            return true;
    }

    public void setlevelView(){

        db = new MySQLiteHelper(this);

        TextView pointsView;
        TextView levelView;
        TextView txtViewUsername;

        String pointsUser;
        String levelName;

        //Getting the scoreboard
        userScore = db.getScore(user.getUser_id());
        pointsU = userScore.getPoints();
        levelName =  db.getUserLevel(user.getUser_id());

        txtViewUsername = (TextView) findViewById(R.id.txtvUsername);
        txtViewUsername.setText(user.getUsername());

        levelView = (TextView) findViewById(R.id.txtvLevel);
        levelView.setText(levelName);

        pointsUser = Integer.toString(pointsU);
        pointsView = (TextView) findViewById(R.id.txtvPoints);
        pointsView.setText(pointsUser+" Points");
    }

    public void onRestart(){
        super.onRestart();
        setlevelView();
    }
}
