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
        word.add(new Word("Ekk","one",R.drawable.number_one));
        word.add(new Word("Dui","two",R.drawable.number_two));
        word.add(new Word("Tin","three",R.drawable.number_three));
        word.add(new Word("Char","four",R.drawable.number_four));
        word.add(new Word("Panch","five",R.drawable.number_five));
        word.add(new Word("Choi","six",R.drawable.number_six));
        word.add(new Word("Sat","seven",R.drawable.number_seven));
        word.add(new Word("Aut","eight",R.drawable.number_eight));
        word.add(new Word("Noy","nine",R.drawable.number_nine));
        word.add(new Word("Dos","ten",R.drawable.number_ten));
        //Recycling
        //ArrayAdapter<Word> itemsAdapter=new ArrayAdapter<Word>(this,R.layout.list_item,word);
        WordAdapter wordAdapter=new WordAdapter(this,word,R.color.numbersColor);

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
