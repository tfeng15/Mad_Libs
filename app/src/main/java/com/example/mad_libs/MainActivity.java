package com.example.mad_libs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/************************************************************************
 *                 Name: Tianyi Feng                                    *
 *                 Email: tfeng@coastal.edu                             *
 *                 Intro Page                                           *
 *                 Assignment #2                                        *
 *                 Using intent to call second activity                 *
 *                 Date:2/7/2019                                        *
 ************************************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Set image

        ImageView Logo = (ImageView)findViewById(R.id.LogoImage);

        Logo.setImageDrawable(getResources().getDrawable(R.drawable.mad_lib_symbol));

        //Explain the rule of the game
        TextView IntroTextView = (TextView)findViewById(R.id.IntroTextView);

        String Intro = getString(R.string.Intro);

        IntroTextView.setText(Intro);


    }
    public void onClickToBegin(View view){

        //Start second activity and enter to the WordInput Page
        Intent intent = new Intent(this, WordInput.class);

        startActivity(intent);


    }
}
