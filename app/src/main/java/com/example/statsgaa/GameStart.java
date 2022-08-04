package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GameStart extends AppCompatActivity {

    MyDatabaseHelper myDB;
    Context context;
    String id, name, number, scores;
    ArrayList<String> player_id, player_name, player_number, player_scores;
    Button endTheGame, btnPlayer1, btnPlayer2, btnPlayer3, btnPlayer4;

    /**
     * displays the details entered from the dialog
     * calls storedatainarrays method
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        endTheGame = findViewById(R.id.endTheGame);
        endTheGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, ShowGameStats.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(GameStart.this);
        player_id = new ArrayList<>();
        player_name = new ArrayList<>();
        player_number = new ArrayList<>();
        player_scores = new ArrayList<>();

        storeDataInArrays();

        btnPlayer1 = findViewById(R.id.btnPlayer1);
        btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("id", toString().valueOf(player_id.get(0)));
                intent.putExtra("name", toString().valueOf(player_name.get(0)));
                intent.putExtra("number", toString().valueOf(player_number.get(0)));
                intent.putExtra("scores", toString().valueOf(player_scores.get(0)));
                startActivity(intent);

            }
        });

        btnPlayer2 = findViewById(R.id.btnPlayer2);
        btnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("id", toString().valueOf(player_id.get(1)));
                intent.putExtra("name", toString().valueOf(player_name.get(1)));
                intent.putExtra("number", toString().valueOf(player_number.get(1)));
                intent.putExtra("scores", toString().valueOf(player_scores.get(1)));
                startActivity(intent);

            }
        });

        btnPlayer3 = findViewById(R.id.btnPlayer3);
        btnPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("id", toString().valueOf(player_id.get(2)));
                intent.putExtra("name", toString().valueOf(player_name.get(2)));
                intent.putExtra("number", toString().valueOf(player_number.get(2)));
                intent.putExtra("scores", toString().valueOf(player_scores.get(2)));
                startActivity(intent);

            }
        });

        btnPlayer4 = findViewById(R.id.btnPlayer4);
        btnPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("id", toString().valueOf(player_id.get(3)));
                intent.putExtra("name", toString().valueOf(player_name.get(3)));
                intent.putExtra("number", toString().valueOf(player_number.get(3)));
                intent.putExtra("scores", toString().valueOf(player_scores.get(3)));
                startActivity(intent);

            }
        });

    }

    /* *
     * Stores data entered into array lists
     */
    public void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                player_id.add(cursor.getString(0));
                player_name.add(cursor.getString(1));
                player_number.add(cursor.getString(2));
                player_scores.add(cursor.getString(3));
            }
        }

    }
}