package com.ecxample.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> family=new ArrayList<Word>();
        family.add(new Word("Abbu","Family Father",R.drawable.family_father));
        family.add(new Word("Ammu","Family Mother",R.drawable.family_mother));
        family.add(new Word("Dada","Grand Father",R.drawable.family_grandfather));
        family.add(new Word("Dadi","Grand Mother",R.drawable.family_grandmother));
        family.add(new Word("Chele","Son",R.drawable.family_son));
        family.add(new Word("Meye","Daughter",R.drawable.family_daughter));
        family.add(new Word("Boro Vai","Older Brother",R.drawable.family_older_brother));
        family.add(new Word("Boro Bon","Older Sister",R.drawable.family_older_sister));
        family.add(new Word("Choto Vai","Younger Brother",R.drawable.family_younger_brother));
        family.add(new Word("Choto Bon","Younger Sister",R.drawable.family_younger_sister));

        WordAdapter wordAdapter=new WordAdapter(this,family);
        ListView listView=(ListView)findViewById(R.id.family);
        listView.setAdapter(wordAdapter);





    }
}
