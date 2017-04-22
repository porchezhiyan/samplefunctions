package com.example.rmdec.sample2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmdec on 21/04/17.
 */

public class SubscribersAdaptor extends ArrayAdapter {



    List list = new ArrayList();



    public void add(Subcribers object) {
        super.add(object);
        list.add(object);
    }

    public SubscribersAdaptor(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public int getCount() {
        return list.size();
    }


    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        SubscribersHolder subscribersHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = layoutInflater.inflate(R.layout.row_layout,parent,false);

            subscribersHolder = new SubscribersHolder();
            subscribersHolder.age = (TextView) row.findViewById(R.id.age);
            subscribersHolder.id = (TextView) row.findViewById(R.id.idval);
            subscribersHolder.name = (TextView) row.findViewById(R.id.name);

            row.setTag(subscribersHolder);







        }

        else{


            subscribersHolder = (SubscribersHolder)row.getTag();





        }

        Subcribers subcribers = (Subcribers)this.getItem(position);
        subscribersHolder.name.setText(subcribers.getName());
        subscribersHolder.age.setText(subcribers.getAge());
        subscribersHolder.id.setText(subcribers.getId());
        return row;
    }

    static class SubscribersHolder{

        TextView name ,id ,age;



    }






}
