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

    private ViewPager mViewPager;
    private ScoreboardClass userScore;
    private LevelClass chosenLevel;
    private int pointsU;
    private UserClass user;
    MySQLiteHelper db;
    Intent intent = new Intent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = (UserClass) getArguments().getParcelable("chosenUser");

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

                    if (pointsU < (1*50))
                        setToast();
                    else
                        setIntent("L02");
                }
            });
            btn3 = (Button) view.findViewById(R.id.imbLevel3);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (2*50))
                        setToast();
                    else
                        setIntent("L03");
                }
            });
            btn4 = (Button) view.findViewById(R.id.imbLevel4);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (3*50))
                        setToast();
                    else
                        setIntent("L04");
                }
            });

            btn5 = (Button) view.findViewById(R.id.imbLevel5);
            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (4*50))
                        setToast();
                    else
                        setIntent("L05");
                }
            });

            btn6 = (Button) view.findViewById(R.id.imbLevel6);
            btn6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (5*50))
                        setToast();
                    else
                        setIntent("L06");
                }
            });

            btn7 = (Button) view.findViewById(R.id.imbLevel7);
            btn7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (6*50))
                        setToast();
                    else
                        setIntent("L07");
                }
            });

            btn8 = (Button) view.findViewById(R.id.imbLevel8);
            btn8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (7*50))
                        setToast();
                    else
                        setIntent("L08");
                }
            });

            btn9 = (Button) view.findViewById(R.id.imbLevel9);
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (8*50))
                        setToast();
                    else
                        setIntent("L09");
                }
            });

            btn10 = (Button) view.findViewById(R.id.imbLevel10);
            btn10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (pointsU < (9*50))
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
    public void setIntent(String chosenLevelID) {
        chosenLevel = db.getLevel(chosenLevelID);

        if (pointsU>(getLevelInt()*50)) {
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
}
