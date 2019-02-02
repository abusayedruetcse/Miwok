package com.ecxample.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> phrases=new ArrayList<Word>();
        phrases.add(new Word("Name","Abu Abdullah"));
        phrases.add(new Word("Country","Bangladesh"));
        phrases.add(new Word("Favourite Fruit","Mango"));

        WordAdapter wordAdapter=new WordAdapter(this,phrases);
        ListView listView=(ListView)findViewById(R.id.phrases);
        listView.setAdapter(wordAdapter);

    }
}
