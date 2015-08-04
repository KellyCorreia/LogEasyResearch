package com.example.kelly.logeasyresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FragmentSlidingLevels extends Fragment {
    private ViewPager mViewPager;
    private ClassScoreboard userScore;
    private ClassLevel chosenLevel;
    private int pointsU;
    private ClassUser user;

    MySQLiteHelper db;
    Intent intent = new Intent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = (ClassUser) getArguments().getParcelable("chosenUser");

        db = new MySQLiteHelper(getActivity());

        userScore = db.getScore(user.getUser_id());
        pointsU = userScore.getPoints();

        // acha o layout da onde vem a page
        return inflater.inflate(R.layout.fragment_base, container, false);
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
            return Integer.toString(position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.level_page, container, false);
            container.addView(view);

            if(position==0)
                setDisplay(view,View.VISIBLE, View.GONE,position+1);
            else
                setDisplay(view,View.GONE, View.VISIBLE,position+1);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    public void setIntent(int a) {
        chosenLevel = db.getLevel(a);
        if (pointsU>=(((chosenLevel.getLevel_id()-1)*50)+10)){
            intent = new Intent(getActivity(), ActivityQuiz.class);
        } else {
            intent = new Intent(getActivity(), ActivityLesson.class);
        }
        intent.putExtra("chosenUser", user);
        intent.putExtra("chosenLevel", chosenLevel);
        intent.putExtra("userScore", userScore);
        startActivity(intent);
    }

    public void setDisplay(View vw,int part1, int part2,int position){
        ImageButton btn;
        RelativeLayout layout = (RelativeLayout) vw.findViewById(R.id.boardLevel);

        for(int i=0;i<10;i++){
            btn = (ImageButton) vw.findViewById(getResources().getIdentifier("imbLevel"+String.valueOf(i+1),"id", getActivity().getPackageName()));
            btn.setOnClickListener(new viewT(i));
        }

        for(int i=10;i>userScore.getLevel_id();i--){
            btn = (ImageButton) vw.findViewById(getResources().getIdentifier("imbLevel"+String.valueOf(i),"id", getActivity().getPackageName()));
            btn.setImageResource(getResources().getIdentifier("level" + String.valueOf(i) + "d", "drawable", getActivity().getPackageName()));
        }

        for(int i=1; i<=5; i++){
            btn = (ImageButton) vw.findViewById(getResources().getIdentifier("imbLevel"+String.valueOf(i),"id", getActivity().getPackageName()));
            btn.setVisibility(part1);
        }
        for(int i=6; i<=10; i++){
            btn = (ImageButton) vw.findViewById(getResources().getIdentifier("imbLevel"+String.valueOf(i),"id", getActivity().getPackageName()));
            btn.setVisibility(part2);
        }

        layout.setBackgroundResource(getResources().getIdentifier("pagina"+String.valueOf(position),"drawable", getActivity().getPackageName()));
    }

    public void setToast() {
        Toast.makeText(getActivity(), "Sorry, but you don't have enough points to access this level!  Answer more question in the levels before!", Toast.LENGTH_SHORT).show();
    }

    class viewT implements View.OnClickListener {
        private int i;

        public viewT(int valor){
            i = valor;
        }

        @Override
        public void onClick(View v) {
            if (pointsU >= (i*50)) {
                if (i < 2) {
                    setIntent(i + 1);
                }
                else{
                    setToast();
                }
            }
            else
                setToast();
        }
    }


}
