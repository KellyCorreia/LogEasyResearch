package com.example.kelly.logeasyresearch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ScoreboardFragment extends Fragment {
    private ScoreboardClass scoreBoard;
    private UserClass user;
    private List<UserClass> userList;
    private MySQLiteHelper dbHelper;
    private ArrayList<ScoreboardScreen> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_scoreboard_, container, false);

        ListView lview = (ListView)view.findViewById(R.id.listview);
        populateList();
        listviewAdapter adapter = new listviewAdapter(getActivity(), list);
        lview.setAdapter(adapter);
        return view;
    }

    private void populateList() {
        String userName, levelName;
        int points;
        long userId;
        double wrongPerc, wrongNum, totalAnswers;

        dbHelper = new MySQLiteHelper(getActivity());
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
            ScoreboardScreen scoreboard = new ScoreboardScreen(userName, levelName, points, wrongPerc);

            dbHelper.addScoreboardScreen(scoreboard);
            list = dbHelper.getScoreboardTable();
        }
    }
}