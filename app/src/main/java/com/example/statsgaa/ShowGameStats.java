package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowGameStats extends AppCompatActivity {

    TextView finalPlayer1Name, finalPlayer1Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_game_stats);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("PLAYER_LIST");
        ArrayList<Player> players = (ArrayList<Player>) args.getSerializable("PLAYER_LIST");

        finalPlayer1Name = findViewById(R.id.finalPlayer1Name);
        finalPlayer1Points = findViewById(R.id.finalPlayer1Points);

        finalPlayer1Name.setText(players.get(0).getPlayerName());
        finalPlayer1Points.setText(String.valueOf(players.get(0).getPlayerScores()));

    }
}