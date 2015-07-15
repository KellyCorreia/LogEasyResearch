package com.example.kelly.logeasyresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import android.text.Html;
import android.widget.Button;


/**
 * Created by mikasa on 14/07/15.
 */


public class SlidingLessonFragment extends Fragment {
    private static int count = 0;

    private ViewPager mViewPager;
    private LevelClass chosenLevel;
    private UserClass user;
    private MySQLiteHelper db;
    private SpannedString lesson;
    private String lessonS;
    ArrayList<String> lessonParts = new ArrayList<String>();

    Intent intent = new Intent();
    Random rd = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        user = (UserClass) getArguments().getParcelable("chosenUser");
        chosenLevel = (LevelClass) getArguments().getParcelable("chosenLevel");
        db = new MySQLiteHelper(getActivity());
        //lesson = new SpannedString(Html.fromHtml(chosenLevel.getLesson()));
        lessonS = chosenLevel.getLesson();
        splitLesson();
        count = lessonParts.size();
        return inflater.inflate(R.layout.fragment_base, container, false);
        //count = quantidade de pages, que varia de aula para aula
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = getActivity().getLayoutInflater().inflate(R.layout.lesson_page, container, false);
            container.addView(view);

            TextView txtLesson = (TextView) view.findViewById(R.id.txtLesson);
            ImageView ImgAvatar = (ImageView) view.findViewById(R.id.imageViewAvatar);

            switch (user.getAvatar()) {
                case "Avatar1":
                    int random = rd.nextInt(4);
                    if (random == 0)
                        ImgAvatar.setImageResource(R.drawable.avatar12);
                    else {
                        if (random == 1)
                            ImgAvatar.setImageResource(R.drawable.avatar13);
                        else {
                            if (random == 2)
                                ImgAvatar.setImageResource(R.drawable.avatar14);
                            else {
                                ImgAvatar.setImageResource(R.drawable.avatar15);
                            }
                        }
                    }
                    break;

                case "Avatar2":
                    random = rd.nextInt(4);
                    if (random == 0)
                        ImgAvatar.setImageResource(R.drawable.avatar22);
                    else {
                        if (random == 1)
                            ImgAvatar.setImageResource(R.drawable.avatar23);
                        else {
                            if (random == 2)
                                ImgAvatar.setImageResource(R.drawable.avatar24);
                            else {
                                ImgAvatar.setImageResource(R.drawable.avatar25);
                            }
                        }
                    }
                    break;

                case "Avatar3":
                    random = rd.nextInt(4);
                    if (random == 0)
                        ImgAvatar.setImageResource(R.drawable.avatar32);
                    else {
                        if (random == 1)
                            ImgAvatar.setImageResource(R.drawable.avatar33);
                        else {
                            if (random == 2)
                                ImgAvatar.setImageResource(R.drawable.avatar34);
                            else {
                                ImgAvatar.setImageResource(R.drawable.avatar35);
                            }
                        }
                    }
                    break;

                case "Avatar4":
                    random = rd.nextInt(4);
                    if (random == 0)
                        ImgAvatar.setImageResource(R.drawable.avatar42);
                    else {
                        if (random == 1)
                            ImgAvatar.setImageResource(R.drawable.avatar43);
                        else {
                            if (random == 2)
                                ImgAvatar.setImageResource(R.drawable.avatar44);
                            else {
                                ImgAvatar.setImageResource(R.drawable.avatar45);
                            }
                        }
                    }
                    break;
            }
           // txtLesson.setText(Html.fromHtml(chosenLevel.getLesson()));
            txtLesson.setText(Html.fromHtml(lessonParts.get(position)));
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    private void splitLesson() {
        TextUtils.StringSplitter splitter = new TextUtils.SimpleStringSplitter('|');
        splitter.setString(lessonS);
        Iterator<String> i = splitter.iterator();
        while(i.hasNext()) {
            lessonParts.add(i.next());
        }
    }
}
