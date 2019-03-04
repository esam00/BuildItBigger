package com.example.android.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    TextView mShowJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        mShowJokeTextView = findViewById(R.id.show_joke);

        String joke = getIntent().getStringExtra("joke");
        if (joke!=null){
            mShowJokeTextView.setText(joke);
        }
    }
}
