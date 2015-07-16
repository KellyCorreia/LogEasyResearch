package com.example.kelly.logeasyresearch;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by mikasa on 14/07/15.
 */
public class UserDetailsFragment extends Fragment {

    private ScoreboardClass userScore;
    private UserClass user;
    private MySQLiteHelper db;
    private LevelClass userLevel;

    private ProgressBar mProgress;

    int circleAvatarV,pointsUV,answeredWrongUV,questionsA;
    String levelNameV,levelDiscripV,usernameUV,emailUV, levelUV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
        TextView answeredQuestions = (TextView)view.findViewById(R.id.answeredQuestionsU);

        circleAvatarV = getResources().getIdentifier(user.getAvatar().toLowerCase(Locale.getDefault()),"drawable",getActivity().getPackageName());
        circleAvatar.setImageResource(circleAvatarV);

        levelNameV =userLevel.getLevelname();
        levelName.setText(levelNameV);

        levelDiscripV = userLevel.getLevelname();
        levelDiscrip.setText(levelDiscripV);

        usernameUV = user.getUsername();
        usernameU.setText(usernameUV);

        emailUV= user.getEmail();
        emailU.setText(emailUV);

        pointsUV = userScore.getPoints();
        pointsU.setText((String.valueOf(pointsUV)));

        answeredWrongUV = userScore.getWrong_number();
        answeredWrongU.setText((String.valueOf(answeredWrongUV)));

        levelUV = userScore.getLevel_id();
        levelU.setText(levelUV);

        questionsA = (pointsUV/10) + answeredWrongUV;
        answeredQuestions.setText(String.valueOf(questionsA));

        mProgress = (ProgressBar) view.findViewById(R.id.progressBarU);
        mProgress.setProgress(pointsUV);

        return view;
    }
}