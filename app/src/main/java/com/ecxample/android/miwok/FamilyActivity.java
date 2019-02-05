package com.ecxample.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Word> family=new ArrayList<Word>();
        family.add(new Word("Abbu","Family Father",R.drawable.family_father,R.raw.family_father));
        family.add(new Word("Ammu","Family Mother",R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("Dada","Grand Father",R.drawable.family_grandfather,R.raw.family_grandfather));
        family.add(new Word("Dadi","Grand Mother",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("Chele","Son",R.drawable.family_son,R.raw.family_son));
        family.add(new Word("Meye","Daughter",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("Boro Vai","Older Brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("Boro Bon","Older Sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("Choto Vai","Younger Brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("Choto Bon","Younger Sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));

        WordAdapter wordAdapter=new WordAdapter(this,family,R.color.familyColor);

        ListView listView=(ListView)findViewById(R.id.family);
        listView.setAdapter(wordAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word familys=family.get(position);
                mediaPlayer=MediaPlayer.create(FamilyActivity.this,familys.getAudioId());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });



    }
    public void releaseMediaPlayer()
    {
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}
