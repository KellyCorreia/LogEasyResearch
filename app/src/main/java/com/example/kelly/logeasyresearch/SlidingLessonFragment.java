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
    private static int count = 1;

    private ViewPager mViewPager;
    private LevelClass chosenLevel;
    private String lessonS;
    ArrayList<String> lessonParts = new ArrayList<>();

    Intent intent = new Intent();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        chosenLevel = (LevelClass) getArguments().getParcelable("chosenLevel");
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
