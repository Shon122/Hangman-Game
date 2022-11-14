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

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.TextView;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Intent;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {
    int index;
    String correctWord;
    String wordOnScreen;
    String userWord;
    String usedLetters;
    String lastWord;
    TextView makafim;
    TextView usedTextv;
    EditText etText;
    public static final String EXTRA_MESSAGE = "com.example.myriads.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        index = 0;
        usedTextv = findViewById(R.id.usedLetters);
        usedTextv.setText("Used Letters: ");
//        correctWord = "android";
//        wordOnScreen = "-------";
        randomWord();

        userWord = "";
        lastWord = "";
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
                userWord = String.valueOf(s.subSequence(start, start + count));
                if (lastWord.length() > userWord.length())
                    lastWord = userWord;
                else
                    letterChanged();
                if (index == 6)
                    loseScreen();
                if (wordOnScreen.equals(correctWord))
                    winScreen();

//                if (index < 6 && !userWord.equals(correctWord)) {
//                    userWord = String.valueOf(s.subSequence(start, start + count));
////
////                    if (userWord.equals(correctWord)) {
////                        wordOnScreen = correctWord;
////                        makafim.setText(wordOnScreen);
////                        etText.setVisibility(View.GONE); // in order to let the user only press the restart button
////
////                    }
//                    if (index < 6 && !userWord.equals(correctWord)) {
//                        letterChanged();
//                    }
//
//
//                }
//                else {
//                    //wordOnScreen = correctWord;
//                    makafim.setText(wordOnScreen);
//                    etText.setVisibility(View.GONE);
//                    //etText.setText("");
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //END OF ONCREATE


    }

    public void letterChanged() {
        char ch = userWord.charAt(userWord.length() - 1);
        String temp1 = String.valueOf(ch);
        //got the char the user just input
        //now check if it is in the correct word, if not picture progresses
        if (!correctWord.contains(temp1)) {
            index++;
            makeInvisible();
        } else {
            for (int j = 0; j < correctWord.length(); j++) {
                if (correctWord.charAt(j) == ch) {
                    String s1, s2;
                    s1 = wordOnScreen.substring(0, j);
                    s2 = wordOnScreen.substring(j + 1, wordOnScreen.length());
                    wordOnScreen = "" + s1 + correctWord.charAt(j) + s2;
                    makafim.setText(wordOnScreen);
                }


            }
        }

        if ((!usedLetters.contains(temp1)) && !correctWord.contains(temp1)) {
            usedLetters += temp1 + ", ";
            usedTextv = findViewById(R.id.usedLetters);
            usedTextv.setText("Used Letters: " + usedLetters);
        }


//
//        int countNew = 0;
//        String newletters = "";
//        for (int i = 0; i < userWord.length(); i++) {
//            char temp = userWord.charAt(i);
//            String s = String.valueOf(temp);
//
//            if (usedLetters.contains(s) == false) {
//                usedLetters += s;
//                countNew++;
//                newletters += s;
//
//
//            }
//
//        }
//
//        if (countNew > 0) {
//            for (int i = 0; i < newletters.length(); i++) {
//                char temp = newletters.charAt(i);
//                String s = String.valueOf(temp);
//                if (!correctWord.contains(s)) {
//                    index++;
//                    makeInvisible();
//                } else {
//
//                    for (int j = 0; j < correctWord.length(); j++) {
//                        if (correctWord.charAt(j) == temp) {
//                            String s1, s2;
//                            s1 = wordOnScreen.substring(0, j);
//                            s2 = wordOnScreen.substring(j + 1, wordOnScreen.length());
//                            wordOnScreen = "" + s1 + correctWord.charAt(j) + s2;
//                            makafim.setText(wordOnScreen);
//                        }
//
//
//                    }
//
//                }
//
//
//            }
//        }
        lastWord = userWord;
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
            //loseScreen();

        }

    }

//
//    public void restartGame(View view) {
//        index = 0;
//        correctWord = "android";
//        wordOnScreen = "-------";
//        userWord = "";
//        usedLetters = "";
//        makafim = findViewById(R.id.makafim);
//        makafim.setText(wordOnScreen);
//        etText = findViewById(R.id.edittextInput);
//        etText.setText("");
//        etText.setVisibility(View.VISIBLE);
//        makeInvisible();
//    }
//


    public void winScreen() {
        Intent intent = new Intent(this, FinishGame.class);
        intent.putExtra(EXTRA_MESSAGE, "You Have Won! The word was " + "'" + correctWord + "'");
        ActivityCompat.finishAffinity(this);
        startActivity(intent);
    }


    public void loseScreen() {
        Intent intent = new Intent(this, FinishGame.class);
        intent.putExtra(EXTRA_MESSAGE, "You Have Lost! The word was " + "'" + correctWord + "'");
        ActivityCompat.finishAffinity(this);
        startActivity(intent);
    }

    public void randomWord() {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("israel");
        arr.add("united kingdom");
        arr.add("australia");
        arr.add("canada");
        arr.add("poland");
        arr.add("mexico");
        arr.add("argentina");
        arr.add("colombia");
        arr.add("new zealand");
        arr.add("romania");
        arr.add("ukraine");
        arr.add("russia");
        arr.add("san marino");
        arr.add("south korea");
        arr.add("north korea");
        //after i have enough countries now i take 1 random

        Random rnd = new Random();
        int n = rnd.nextInt(arr.size());
        correctWord = arr.get(n);
        wordOnScreen = "";
        for (int i = 0; i < correctWord.length(); i++) {
            if(correctWord.charAt(i) != ' ')
                wordOnScreen+= "-";
            else
                wordOnScreen+= " ";
        }


    }
    //End of main
}




