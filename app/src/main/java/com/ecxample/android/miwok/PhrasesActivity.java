package com.ecxample.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> phrases=new ArrayList<Word>();
        phrases.add(new Word("Name","Abu Abdullah",R.raw.phrase_are_you_coming));
        phrases.add(new Word("Country","Bangladesh",R.raw.phrase_come_here));
        phrases.add(new Word("Favourite Fruit","Mango",R.raw.phrase_how_are_you_feeling));

        WordAdapter wordAdapter=new WordAdapter(this,phrases,R.color.phrasesColor);
        ListView listView=(ListView)findViewById(R.id.phrases);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Word phrase=phrases.get(position);
                mediaPlayer=MediaPlayer.create(PhrasesActivity.this,phrase.getAudioId());
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

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
