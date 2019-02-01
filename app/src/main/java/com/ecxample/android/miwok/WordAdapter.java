package com.ecxample.android.miwok;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class WordAdapter extends ArrayAdapter<Word> {
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
