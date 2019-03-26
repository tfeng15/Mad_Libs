package com.example.mad_libs;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/************************************************************************
 *                 Name: Tianyi Feng                                    *
 *                 Email: tfeng@coastal.edu                             *
 *                 Word Input Page                                      *
 *                 Assignment #2                                        *
 *                 Using intent to call second activity                 *
 *                 Date:2/7/2019                                        *
 ************************************************************************/


public class WordInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_input);


        // Tell user to type
        TextView IntroTextView = (TextView)findViewById(R.id.IntroTextView);
        IntroTextView.setText("Fill in the words to complete the story");


        //get a reference to tell users how many words left
        final TextView WordsLeftTextView = (TextView)findViewById(R.id.WordsLeftTextView);
        //get a reference to tell uses the types of the words
        final TextView TipTextView = (TextView)findViewById(R.id.TipTextView1);
        //get a reference to the edittext that let user type the word
        final EditText WordEditText = (EditText)findViewById(R.id.WordEditText);
        //get the reference to the "save and reset" button
        final Button button = (Button)findViewById(R.id.button);
        //get the reference that transferring the text to the next activity
        final Intent intent = new Intent (this, ShowStory.class);



        Resources resource = getResources();

        //get the text
        String fileName = resource.getString(R.string.Story);



        Log.d("Debug","file name is "+ fileName);

        AssetManager assetManager = getAssets();

        try {
            final InputStream inputStream = assetManager.open(fileName);


            // get methods from the MadLibStory.java
            final MadLibStory madLibStory = new MadLibStory(inputStream);


            inputStream.close();

            // use method "getNextPlaceholder" to get the type of the first placeholder
            final String string = madLibStory.getNextPlaceholder();
            // claim the type of the word to the users
            TipTextView.setText("Please enter a/an\t"+ string);


            // use method "getPlaceholderRemainingCount()" to see how many words left
            int WordLeft = madLibStory.getPlaceholderRemainingCount();
            //claim how many wors left to the users
            WordsLeftTextView.setText("You have\t" + WordLeft+ "\twords left");



            //set up listener to the button which saves word and reset
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    //get what user types in the EditText
                    String WordInput = WordEditText.getText().toString();
                    //use method fillInPlaceholder to fill the placeholder with the word user types
                    madLibStory.fillInPlaceholder(WordInput);



                    String string = madLibStory.getNextPlaceholder();
                    TipTextView.setText("Please enter a/an\t" + string);

                    int WordLeft = madLibStory.getPlaceholderRemainingCount();
                    WordsLeftTextView.setText("You have\t" +WordLeft +"\twords left");



                    // it there is no word left to fill in, we transfer the text to the third activity
                    if(WordLeft == 0 ){

                        // using method "toString" to get the text
                        String text = madLibStory.toString();

                        // Pass it to third party and show it
                        intent.putExtra(ShowStory.EXTRA_MESSAGE, text);

                        startActivity(intent);


                    }


                }
            });




        } catch (IOException ioe) {
            Log.e("IO ERROR", ioe.getMessage());

        }





    }
}
