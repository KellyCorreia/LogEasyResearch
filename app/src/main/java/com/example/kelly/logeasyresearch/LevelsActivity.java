package com.example.kelly.logeasyresearch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class LevelsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        //Getting the object user from the previous screen
        Bundle extras = getIntent().getExtras();
        UserClass user = extras.getParcelable("chosenUser");

        if (savedInstanceState == null) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingLevelsFragment fragment = new SlidingLevelsFragment();

            Bundle args = new Bundle();
            args.putParcelable("chosenUser", user);
            fragment.setArguments(args);

            // aqui ele seta o que vai ser substituido dentro do layout
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();

            Toast.makeText(LevelsActivity.this, "Welcome, " + user.getUsername() + " !", Toast.LENGTH_SHORT).show();
            Toast.makeText(LevelsActivity.this, "Choose a Level to start the challenge!", Toast.LENGTH_SHORT).show();
        }

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


/*
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
    */
}
