package com.ecxample.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button numbersButtonView=(Button)findViewById(R.id.numbersButton);
        numbersButtonView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_numbers=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent_numbers);
            }
        });
        Button familyButtonView=(Button)findViewById(R.id.familyButton);
        familyButtonView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_family=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(intent_family);
            }
        });
        Button colorsButtonView=(Button)findViewById(R.id.colorsButton);
        colorsButtonView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_colors=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent_colors);
            }
        });
        Button phrasesButtonView=(Button)findViewById(R.id.phrasesButton);
        phrasesButtonView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_phrases=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(intent_phrases);
            }
        });


    }
    /**
    public void numbersButtonClick(View view)
    {
        Intent intent_numbers=new Intent(MainActivity.this,NumbersActivity.class);
        startActivity(intent_numbers);


    }
    public void familyButtonClick(View view)
    {
        Intent intent_family=new Intent(MainActivity.this,FamilyActivity.class);
        startActivity(intent_family);


    }
    public void colorsButtonClick(View view)
    {
        Intent intent_colors=new Intent(MainActivity.this,ColorsActivity.class);
        startActivity(intent_colors);


    }
    public void phrasesButtonClick(View view)
    {
        Intent intent_phrases=new Intent(MainActivity.this,PhrasesActivity.class);
        startActivity(intent_phrases);


    }
     */

}
