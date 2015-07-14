package com.example.kelly.logeasyresearch;

/**
 * Created by mikasa on 14/07/15.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;


public class UserDetailsFragment extends Fragment {

    private ScoreboardClass userScore;
    private UserClass user;
    MySQLiteHelper db;
    private LevelClass userLevel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userdetails, container, false);
        user = getArguments().getParcelable("chosenUser");

        db = new MySQLiteHelper(getActivity());
        userScore = db.getScore(user.getUser_id());

        userLevel = db.getLevel(userScore.getLevel_id());

        ImageView circleAvatar = (ImageView)view.findViewById(R.id.circleAvatar);
        TextView levelName = (TextView)view.findViewById(R.id.levelName);
        TextView levelDiscrip = (TextView)view.findViewById(R.id.levelDiscrip);
        TextView usernameU = (TextView)view.findViewById(R.id.usernameU);
        TextView emailU = (TextView)view.findViewById(R.id.emailU);
        TextView pointsU = (TextView)view.findViewById(R.id.pointsU);
        TextView levelU = (TextView)view.findViewById(R.id.levelU);
        TextView answeredWrongU = (TextView)view.findViewById(R.id.answeredWrongU);

        circleAvatar.setImageResource(getResources().getIdentifier(user.getAvatar().toLowerCase(Locale.getDefault()),"drawable",getActivity().getPackageName()));
        levelName.setText(userLevel.getLevelname());
        levelDiscrip.setText(userLevel.getLevelname());
        usernameU.setText(user.getUsername());
        emailU.setText(user.getEmail());
        pointsU.setText(userScore.getPoints());
        levelU.setText(userScore.getLevel_id());
        answeredWrongU.setText(userScore.getWrong_number());

        return view;
    }
}