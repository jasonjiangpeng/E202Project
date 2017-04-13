package com.aotome202.lostjason.e202project.fragment;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aotome202.lostjason.e202project.R;

import java.util.List;

/**
 * Created by LostJason on 2017/4/10.
 */

public class MessagePageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
           View  view =inflater.inflate(R.layout.fragment_message, container,false);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    class  MessageAdapter extends BaseAdapter{

        public MessageAdapter() {
        }

        @Override
        public int getCount() {
            return 0;
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
            MessageHolder messageHolder;
            if (convertView==null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_message, null);
            }



            return null;
        }
    }
     class MessageHolder {
         ImageView img;
         TextView tital;
         TextView message;

     }

}
