package com.example.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



/************************************************************************
 *                 Name: Tianyi Feng                                    *
 *                 Email: tfeng@coastal.edu                             *
 *                 Story Page                                           *
 *                 Assignment #2                                        *
 *                 Using intent to call second activity                 *
 *                 Date:2/7/2019                                        *
 ************************************************************************/

public class ShowStory extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);


        //get the text from the second activity
        Intent intent = getIntent();

        String story = intent.getStringExtra(EXTRA_MESSAGE);

        TextView StoryTextView = (TextView)findViewById(R.id.StoryTextView);

        //display the story!
        StoryTextView.setText(story);



    }

    public void onClickToBack(View view){


        // go back to make another story
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }
}
