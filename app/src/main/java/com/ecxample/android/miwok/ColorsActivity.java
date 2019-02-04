package com.ecxample.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Word> colors=new ArrayList<Word>();
        colors.add(new Word("Kalo","Black",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("Badami","Brown",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("Dhusor Holud","Dusty Yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("Dhusor","Gray",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("Sobuj","Green",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("Mul Holud","Mustard Yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        colors.add(new Word("Lal","Red",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("Sada","White",R.drawable.color_white,R.raw.color_white));

        WordAdapter wordAdapter=new WordAdapter(this,colors,R.color.colorsColor);
        ListView listView=(ListView)findViewById(R.id.colors);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word color=colors.get(position);
                mediaPlayer=MediaPlayer.create(ColorsActivity.this,color.getAudioId());
                mediaPlayer.start();

            }
        });
    }
}
