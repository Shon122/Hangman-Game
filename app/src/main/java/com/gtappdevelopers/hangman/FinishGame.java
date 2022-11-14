package com.gtappdevelopers.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

import android.content.Intent;
import android.content.SharedPreferences;

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

public class FinishGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.LoseWinText);
        textView.setText(message);

        if(message.contains("Lost"))
        {
            ImageView imageView= findViewById(R.id.youlose);
            imageView.setVisibility(View.VISIBLE);

        }
        else
        {
            ImageView imageView= findViewById(R.id.youwin);
            imageView.setVisibility(View.VISIBLE);

        }

    }


    public void backToGame(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        ActivityCompat.finishAffinity(this);
        startActivity(intent);


    }
}