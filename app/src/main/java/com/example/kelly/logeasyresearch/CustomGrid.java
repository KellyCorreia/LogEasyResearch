package com.example.kelly.logeasyresearch;

/**
 * Created by Kelly on 07/04/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGrid extends BaseAdapter{
        private Context mContext;
        private final List<String> web;
        private final List<Integer> Imageid;
        public CustomGrid(Context c,List<String> web,List<Integer> imageid) {
            mContext = c;
            this.Imageid = imageid;
            this.web = web;
        }
        @Override
        public int getCount() {
            return web.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View grid;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                grid = new View(mContext);
                grid = inflater.inflate(R.layout.grid_single, null);
                TextView  textView  = (TextView) grid.findViewById(R.id.grid_text);
                ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
                textView.setText(web.get(position));
                imageView.setImageResource(Imageid.get(position));
            } else {
                grid = (View) convertView;
            }
            return grid;
        }
    }