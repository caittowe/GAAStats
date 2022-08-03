package com.example.statsgaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GameStart extends AppCompatActivity {


    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> player_id, player_name, player_number, player_scores;
    CustomAdapterStat customAdapter;
    TextView team1, team2, time, date, location;
    Button endTheGame;

    /**
     * displays the details entered from the dialog
     * calls storedatainarrays method
     * calls the custom adapter to layout the recycler view of all players
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        recyclerView = findViewById(R.id.recyclerView);
        team1 = findViewById(R.id.tvTeam1);
        team2 = findViewById(R.id.tvTeam2);
        time = findViewById(R.id.tvTime);
        date = findViewById(R.id.tvDate);
        location = findViewById(R.id.tvLocation);
        endTheGame = findViewById(R.id.endTheGame);
        endTheGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, ShowGameStats.class);
                startActivity(intent);
            }
        });
//
//        team1.setText(getIntent().getStringExtra("TEAM1"));
//        team2.setText(getIntent().getStringExtra("TEAM2"));
//        date.setText(getIntent().getStringExtra("DATE"));
//        time.setText(getIntent().getStringExtra("TIME"));
//        location.setText(getIntent().getStringExtra("LOCATION"));

        myDB = new MyDatabaseHelper(GameStart.this);
        player_id = new ArrayList<>();
        player_name = new ArrayList<>();
        player_number = new ArrayList<>();
        player_scores = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapterStat(GameStart.this, this, player_id, player_name, player_number, player_scores);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(GameStart.this));
    }

    /**
     * allows results to be seen when data is changed
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    /**
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

    /**
     * inflates the menu oin top corner of screen +++not yet implemented++
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
}