package com.example.rmdec.sample2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmdec on 21/04/17.
 */

public class SubscribersAdaptor extends ArrayAdapter {



    List list = new ArrayList();


    @Override
    public void add(Object object) {
        super.add(object);
    }

    public SubscribersAdaptor(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public int getCount() {
        return super.getCount();
    }


    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }
}
