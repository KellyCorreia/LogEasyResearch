package com.example.kelly.logeasyresearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelsAdapter extends RecyclerView.Adapter<LevelsAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private String[] mDataset;
    private OnItemClickListener mListener;
    private int ICONS[];
    private String NAME;
    private String EMAIL;
    private int PROFILE;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView email;


        public ViewHolder(View itemView,int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);
            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
                Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row
            }
            else{


                Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
                email = (TextView) itemView.findViewById(R.id.email);       // Creating Text View object from header.xml for email
                profile = (ImageView) itemView.findViewById(R.id.circleView);// Creating Image view object from header.xml for profile pic
                Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
            }
        }
    }

    public LevelsAdapter(String[] myDataset,int mICONS[],String mNAME,String mEMAIL, int mPROFILE, OnItemClickListener listener) {
        mDataset = myDataset;
        mListener = listener;
        ICONS = mICONS;
        NAME =mNAME;
        EMAIL = mEMAIL;
        PROFILE = mPROFILE;
    }

    @Override
    public LevelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false); //Inflating the layout

            return new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

             // Returning the created object

            //inflate your layout and pass it to view holder

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false); //Inflating the layout

            return new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

             //returning the object created

        }
        return null;

    }

    @Override
    public void onBindViewHolder(LevelsAdapter.ViewHolder holder, final int position) {

        if(holder.Holderid ==1) {                              // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image
            holder.textView.setText(mDataset[position - 1]); // Setting the Text with the array of our Titles
            holder.imageView.setImageResource(ICONS[position - 1]);// Settimg the image with array of our icons
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onClick(view, position-1);
                }
            });
        }
        else{
            holder.profile.setImageResource(PROFILE);           // Similarly we set the resources for header view
            holder.Name.setText(NAME);
            holder.email.setText(EMAIL);
        }
    }


    // This method returns the number of items present in the list
    @Override
    public int getItemCount() {
        return mDataset.length+1;
    }


    // With the following method we check what type of view is being passed

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


}


