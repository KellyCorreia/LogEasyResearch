package com.example.kelly.logeasyresearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Scoreboard_Activity extends Activity {
    private ScoreboardClass scoreBoard;
    private UserClass user;
    private List<UserClass> userList;
    private MySQLiteHelper dbHelper;
    private ArrayList<ScoreboardScreen> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_);

        ListView lview = (ListView) findViewById(R.id.listview);
        populateList();
        listviewAdapter adapter = new listviewAdapter(this, list);
        lview.setAdapter(adapter);

        Button btnScore = (Button) findViewById(R.id.btnBackLevels);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

   private void populateList() {
       String userName, levelName;
       int points;
       long userId;
       double wrongPerc, wrongNum, totalAnswers;

       dbHelper = new MySQLiteHelper(this);
       userList = dbHelper.getAllUsers();

       dbHelper.deleteScoreboardTable();

       for (int i = 0; i < userList.size(); i++){
           user = userList.get(i);
           userId = user.getUser_id();
           userName = user.getUsername();
           levelName = dbHelper.getUserLevel(userId);
           scoreBoard = dbHelper.getScore(userId);
           points = scoreBoard.getPoints();
           wrongNum = scoreBoard.getWrong_number();
           totalAnswers = wrongNum + (points/10);
           wrongPerc = 0.0;
           if(totalAnswers != 0){
               wrongPerc = (wrongNum/totalAnswers)*100;
               wrongPerc = Double.parseDouble(new DecimalFormat("0.0").format(wrongPerc));
           }

           //Toast.makeText(Scoreboard_Activity.this, "num Erradas: " + wrongNum + " perc erradas: " + wrongPerc + "Total: " + totalAnswers, Toast.LENGTH_LONG).show();
           ScoreboardScreen scoreboard = new ScoreboardScreen(userName, levelName, points, wrongPerc);

           dbHelper.addScoreboardScreen(scoreboard);
           list = dbHelper.getScoreboardTable();
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoreboard_, menu);
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
}
