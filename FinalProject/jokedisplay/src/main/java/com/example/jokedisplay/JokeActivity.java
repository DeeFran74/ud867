package com.example.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "EXTRA_JOKE_KEY";

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        jokeTextView = findViewById(R.id.textViewJokeDisplay);

        // If intent was passed joke extra, display it
        if (intent.hasExtra(EXTRA_JOKE)) {
            String jokeToDisplay = intent.getStringExtra(EXTRA_JOKE);

            jokeTextView.setText(jokeToDisplay);

        }

    }
}
