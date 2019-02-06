package com.ecxample.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager ;
    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                        // Pause playback
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mediaPlayer.start();
                    }
                }
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        mAudioManager= (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> word=new ArrayList<Word>();
        word.add(new Word("Ekk","one",R.drawable.number_one,R.raw.number_one));
        word.add(new Word("Dui","two",R.drawable.number_two,R.raw.number_two));
        word.add(new Word("Tin","three",R.drawable.number_three,R.raw.number_three));
        word.add(new Word("Char","four",R.drawable.number_four,R.raw.number_four));
        word.add(new Word("Panch","five",R.drawable.number_five,R.raw.number_five));
        word.add(new Word("Choi","six",R.drawable.number_six,R.raw.number_six));
        word.add(new Word("Sat","seven",R.drawable.number_seven,R.raw.number_seven));
        word.add(new Word("Aut","eight",R.drawable.number_eight,R.raw.number_eight));
        word.add(new Word("Noy","nine",R.drawable.number_nine,R.raw.number_nine));
        word.add(new Word("Dos","ten",R.drawable.number_ten,R.raw.number_ten));
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    Word words=word.get(position);
                    mediaPlayer=MediaPlayer.create(NumbersActivity.this,words.getAudioId());
                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });

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
    //
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

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
