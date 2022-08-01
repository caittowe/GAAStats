package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class EnterStat extends AppCompatActivity {

    Button point, endGameHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stat);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("PLAYER_LIST");
        ArrayList<Player> players = (ArrayList<Player>) args.getSerializable("PLAYER_LIST");
        String title = intent.getStringExtra("TAG");
        setTitle(title);

        endGameHere = findViewById(R.id.endGameHere);
        endGameHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterStat.this, ShowGameStats.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("PLAYER_LIST",(Serializable)players);
                intent.putExtra("PLAYER_LIST",bundle);
                startActivity(intent);
            }
        });
        point = findViewById(R.id.pointButton);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                players.get(0).addScore();
                Toast.makeText(EnterStat.this, "Point added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}