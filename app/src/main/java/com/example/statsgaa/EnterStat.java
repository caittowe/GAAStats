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

    String number, id, name, scores;
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
        ab.setTitle(number + ". " + name);

        // increments number of pages by 1
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(1, Integer.parseInt(id), scoreID, 2);
                startActivity(intent);
                Log.i("SCOREADDED", "Score added player id: "+id);
            }
        });

        addFistpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(1, Integer.parseInt(id), handpassID, 2);
                startActivity(intent);
                Log.i("FISTADDED", "Fistpass added player id: "+id);
            }
        });

    addKickpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
            Intent intent = new Intent(EnterStat.this, GameStart.class);
            myDB.addMatchEvent(1, Integer.parseInt(id), kickpassID, 2);
            startActivity(intent);
            Log.i("KICKADDED", "kickpass added player id: "+id);
        }
    });
}

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("scores")) {
            // getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");
            scores = getIntent().getStringExtra("scores");



        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}