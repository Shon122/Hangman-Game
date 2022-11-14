package com.gtappdevelopers.hangman;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int index;
    String correctWord;
    String wordOnScreen;
    String userWord;
    String usedLetters;
    TextView makafim;
    EditText etText;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 0;
        correctWord = "android";
        wordOnScreen = "-------";
        userWord = "";
        usedLetters = "";
        makafim = findViewById(R.id.makafim);
        makafim.setText(wordOnScreen);
        etText = findViewById(R.id.edittextInput);


        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (index < 6 && !userWord.equals(correctWord)) {
                    userWord = String.valueOf(s.subSequence(start, start + count));
//
//                    if (userWord.equals(correctWord)) {
//                        wordOnScreen = correctWord;
//                        makafim.setText(wordOnScreen);
//                        etText.setVisibility(View.GONE); // in order to let the user only press the restart button
//
//                    }
                    if (index < 6 && !userWord.equals(correctWord)) {
                        letterChanged();
                    }


                }
                else {
                    //wordOnScreen = correctWord;
                    makafim.setText(wordOnScreen);
                    etText.setVisibility(View.GONE);
                    //etText.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //END OF ONCREATE


    }

    public void letterChanged() {
        int countNew = 0;
        String newletters = "";
        for (int i = 0; i < userWord.length(); i++) {
            char temp = userWord.charAt(i);
            String s = String.valueOf(temp);

            if (usedLetters.contains(s) == false) {
                usedLetters += s;
                countNew++;
                newletters += s;


            }

        }

        if (countNew > 0) {
            for (int i = 0; i < newletters.length(); i++) {
                char temp = newletters.charAt(i);
                String s = String.valueOf(temp);
                if (!correctWord.contains(s)) {
                    index++;
                    makeInvisible();
                } else {

                    for (int j = 0; j < correctWord.length(); j++) {
                        if (correctWord.charAt(j) == temp) {
                            String s1, s2;
                            s1 = wordOnScreen.substring(0, j);
                            s2 = wordOnScreen.substring(j + 1, wordOnScreen.length());
                            wordOnScreen = "" + s1 + correctWord.charAt(j) + s2;
                            makafim.setText(wordOnScreen);
                        }


                    }

                }


            }
        }
    }

    public void makeInvisible() {
        int count = 0;
        ImageView ivHolder;
        if (index > 6)
            index = 6;
        ivHolder = findViewById(R.id.hangman0);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman1);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman2);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman3);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman4);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman5);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index)
            ivHolder.setVisibility(View.VISIBLE);
        count++;
        ivHolder = findViewById(R.id.hangman6);
        ivHolder.setVisibility(View.INVISIBLE);
        if (count == index) {
            ivHolder.setVisibility(View.VISIBLE);
            //last one so the player lost
            etText.setVisibility(View.GONE);

        }

    }


    public void restartGame(View view) {
        index = 0;
        correctWord = "android";
        wordOnScreen = "-------";
        userWord = "";
        usedLetters = "";
        makafim = findViewById(R.id.makafim);
        makafim.setText(wordOnScreen);
        etText = findViewById(R.id.edittextInput);
        etText.setText("");
        etText.setVisibility(View.VISIBLE);
        makeInvisible();
    }


    //End of main
}




