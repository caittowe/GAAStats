package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.io.Serializable;
import java.util.ArrayList;

public class StatActivity extends AppCompatActivity {

    String playersName1, playersName2, playersName3, playersName4, playersName5, playersName6;
    MaterialButton btnPlayer1, btnPlayer2;
    TextView playerName1, playerName2;
    Button endGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("PLAYER_LIST");
        ArrayList<Player> players = (ArrayList<Player>) args.getSerializable("PLAYER_LIST");

        // sets textview under jersey to name of player entered
        playerName1 = findViewById(R.id.playerName1);
        playersName1 = players.get(0).getPlayerName().toString();
        playerName1.setText(playersName1);
        // when button is clicked, activity appears
        btnPlayer1 = findViewById(R.id.kk2);
        btnPlayer1.setTag("1."+playersName1);
        btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(StatActivity.this, EditPlayer.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("PLAYER_LIST",(Serializable)players);
                intent.putExtra("PLAYER_LIST",bundle);
                intent.putExtra("TAG",btnPlayer1.getTag().toString());
                startActivity(intent);
            }
        });

        btnPlayer2 = findViewById(R.id.kk);
        playerName2 = findViewById(R.id.playerName2);
        playersName2 =players.get(1).getPlayerName().toString();
        playerName2.setText(playersName2);
        btnPlayer2.setTag(playersName2);
        btnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Bundle bundle = new Bundle();
                String thePlayerName = playersName2.toString();
                bundle.putSerializable("players", players );
                EnterStatFragment fragInfo = new EnterStatFragment();
                fragInfo.setArguments(bundle);
                ft.replace(R.id.enterStatFrame, fragInfo);
                ft.commit();
            }
        });

        endGame = findViewById(R.id.endGame);
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatActivity.this, ShowGameStats.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("PLAYER_LIST",(Serializable)players);
                intent.putExtra("PLAYER_LIST",bundle);
                startActivity(intent);
            }
        });

    }

}