package com.example.statsgaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnterStat extends AppCompatActivity {

    private Button addScore;

    String number, id, name, scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stat);


        addScore = findViewById(R.id.addScore);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(number + ". " + name);
        if (ab != null) {
            ab.setTitle(number + ". " + name);
        }

        // increments number of pages by 1
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                int increment = 1;
                int oldScore = Integer.valueOf(scores);
                int newScore = oldScore + increment;
                myDB.updateData(id, name, number, String.valueOf(newScore));
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                startActivity(intent);
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