package com.example.statsgaa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.statsgaa.R;

public class NewGame extends AppCompatActivity {

    TextView team1, team2, date, time, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        team1 = findViewById(R.id.tvTeam1);
        team2 = findViewById(R.id.tvTeam2);
        date = findViewById(R.id.tvDate);
        time = findViewById(R.id.tvTime);
        location = findViewById(R.id.tvLocation);

        team1.setText(getIntent().getStringExtra("TEAM1"));
        team2.setText(getIntent().getStringExtra("TEAM2"));
        date.setText(getIntent().getStringExtra("DATE"));
        time.setText(getIntent().getStringExtra("TIME"));
        location.setText(getIntent().getStringExtra("LOCATION"));

    }
}