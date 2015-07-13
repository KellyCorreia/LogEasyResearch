package com.example.kelly.logeasyresearch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SlidingLevelsFragment extends Fragment {

    MySQLiteHelper db;
    Intent intent = new Intent();
    private ViewPager mViewPager;
    private ScoreboardClass userScore;
    private LevelClass chosenLevel;
    private int pointsU;
    private UserClass user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = getArguments().getParcelable("chosenUser");

        db = new MySQLiteHelper(getActivity());

        userScore = db.getScore(user.getUser_id());
        pointsU = userScore.getPoints();


        // acha o layout da onde vem a page
        return inflater.inflate(R.layout.fragment_boardlevel, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

    }

    public void setIntent(String chosenLevelID) {
        chosenLevel = db.getLevel(chosenLevelID);


        if (enoughPoints(getLevelInt())) {
            intent = new Intent(getActivity(), QuizActivity.class);
        } else {
            intent = new Intent(getActivity(), LessonActivity.class);
        }
        intent.putExtra("chosenUser", user);
        intent.putExtra("chosenLevel", chosenLevel);
        intent.putExtra("userScore", userScore);
        startActivity(intent);


    }

    public int getLevelInt() {
        switch (userScore.getLevel_id()) {
            case "L01":
                return 1;
            case "L02":
                return 2;
            case "L03":
                return 3;
            case "L04":
                return 4;
            case "L05":
                return 5;
            case "L06":
                return 6;
            case "L07":
                return 7;
            case "L08":
                return 8;
            case "L09":
                return 9;
            case "L010":
                return 10;
            default:
                return 0;
        }
    }

    public void setToast() {
        Toast.makeText(getActivity(), "Sorry, but you don't have enough points to access this level!  Answer more question in the levels before!", Toast.LENGTH_SHORT).show();
    }

    public boolean enoughPoints(int level) {
        int valor = level * 50;
        if(pointsU > valor){
            return true;
        }else
            return false;
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "Item " + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.level_page, container, false);
            container.addView(view);


            //AQUI É MUDADO O CONTENT DA PAGE
            Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
            RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.boardLevel);


            btn1 = (Button) view.findViewById(R.id.imbLevel1);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setIntent("L01");
                }
            });
            btn2 = (Button) view.findViewById(R.id.imbLevel2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (enoughPoints(1))
                        setToast();
                    else
                        setIntent("L02");
                }
            });
            btn3 = (Button) view.findViewById(R.id.imbLevel3);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(2)) {
                        setToast();
                    } else
                        setIntent("L03");
                }
            });
            btn4 = (Button) view.findViewById(R.id.imbLevel4);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(3))
                        setToast();
                    else
                        setIntent("L04");
                }
            });

            btn5 = (Button) view.findViewById(R.id.imbLevel5);
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(4))
                        setToast();
                    else
                        setIntent("L05");
                }
            });

            btn6 = (Button) view.findViewById(R.id.imbLevel6);
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(5))
                        setToast();
                    else
                        setIntent("L06");
                }
            });

            btn7 = (Button) view.findViewById(R.id.imbLevel7);
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(6))
                        setToast();
                    else
                        setIntent("L07");
                }
            });

            btn8 = (Button) view.findViewById(R.id.imbLevel8);
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(7))
                        setToast();
                    else
                        setIntent("L08");
                }
            });

            btn9 = (Button) view.findViewById(R.id.imbLevel9);
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(8))
                        setToast();
                    else
                        setIntent("L09");
                }
            });

            btn10 = (Button) view.findViewById(R.id.imbLevel10);
            btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (enoughPoints(9))
                        setToast();
                    else
                        setIntent("L010");
                }
            });

            if (position == 0) {
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);

                btn6.setVisibility(View.GONE);
                btn7.setVisibility(View.GONE);
                btn8.setVisibility(View.GONE);
                btn9.setVisibility(View.GONE);
                btn10.setVisibility(View.GONE);
                layout.setBackgroundResource(R.drawable.pagina1);
            } else {
                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);
                btn5.setVisibility(View.GONE);

                btn6.setVisibility(View.VISIBLE);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                layout.setBackgroundResource(R.drawable.pagina2);
            }

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
/*

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

}

*/
