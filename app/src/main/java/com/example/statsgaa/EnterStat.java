package com.example.statsgaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterStat extends AppCompatActivity {

    private Button addScore, addKickpass, addFistpass;

    String squad_table_id, squad_id, squad_name, player_name, player_no;
    int scoreID = 1;
    int kickpassID = 2;
    int handpassID = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stat);

        addScore = findViewById(R.id.addScore);
        addKickpass = findViewById(R.id.addKickpass);
        addFistpass = findViewById(R.id.addFirstpass);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(player_no + ". " + player_name);

        // increments number of pages by 1
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(1, Integer.parseInt(player_no), scoreID, 2);
                startActivity(intent);
                Log.i("SCOREADDED", "Score added player "+player_no);
            }
        });

        addFistpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(1, Integer.parseInt(player_no), handpassID, 2);
                startActivity(intent);
                Log.i("FISTADDED", "Fistpass added player "+player_no);
            }
        });

    addKickpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
            Intent intent = new Intent(EnterStat.this, GameStart.class);
            myDB.addMatchEvent(1, Integer.parseInt(player_no), kickpassID, 2);
            startActivity(intent);
            Log.i("KICKADDED", "kickpass added player "+player_no);
        }
    });
}

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("squad_table_id") && getIntent().hasExtra("squad_id") && getIntent().hasExtra("squad_name") && getIntent().hasExtra("player_name")
        && getIntent().hasExtra("player_no")){
            // getting data from intent
            squad_table_id = getIntent().getStringExtra("squad_table_id");
            squad_id = getIntent().getStringExtra("squad_id");
            squad_name = getIntent().getStringExtra("squad_name");
            player_name = getIntent().getStringExtra("player_name");
            player_no = getIntent().getStringExtra("player_no");

        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}