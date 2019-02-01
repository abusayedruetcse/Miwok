package com.ecxample.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> word=new ArrayList<Word>();
        word.add(new Word("Ekk","one"));
        word.add(new Word("Dui","two"));
        word.add(new Word("Tin","three"));
        word.add(new Word("Char","four"));
        word.add(new Word("Panch","five"));
        word.add(new Word("Choi","six"));
        word.add(new Word("Sat","seven"));
        word.add(new Word("Aut","eight"));
        word.add(new Word("Noy","nine"));
        word.add(new Word("Dos","ten"));
        //Recycling
        //ArrayAdapter<Word> itemsAdapter=new ArrayAdapter<Word>(this,R.layout.list_item,word);
        WordAdapter wordAdapter=new WordAdapter.getView(this,0,word);
        /**
        //Using GridView
        GridView gridView=(GridView)findViewById(R.id.gridView);
        gridView.setAdapter(itemsAdapter);
         */

          //Using ListView
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(wordAdapter);


        /**
         * //Using LinearLayout
        int len=word.size();
        int count=0;
        LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);
        while (count<len)
        {
            TextView wordView=new TextView(this);
            wordView.setText(word.get(count));
            rootView.addView(wordView);
            count++;
        }
         */


    }
}
