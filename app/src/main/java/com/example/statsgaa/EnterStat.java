package com.example.statsgaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.statsgaa.databinding.ActivityEnterStatBinding;
import com.example.statsgaa.databinding.ActivityShowGameStatsBinding;

public class EnterStat extends AppCompatActivity {

    ActivityEnterStatBinding binding;

    String squadTableID, squadID, squadName, playerName, playerNo, clickedSquadID;

    public static int SHOTID = 1;
    public static int POINTID = 2;
    public static int GOALID = 3;
    public static int WIDEID = 4;
    public static int KICKOUTID = 5;
    public static int OWNKICKOUTWONID = 6;
    public static int OPPKICKOUTWONID = 7;
    public static int POSTURNOVERID = 8;
    public static int NEGTURNOVERID = 9;
    public static int FOULWONID = 10;
    public static int FOULCONCID = 11;
    public static int POSSESSIONID = 12;
    String timestamp;
    int scorePoints;
    int scoreGoals;
    int gameID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterStatBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // first we call this
        getAndSetIntentData();
        gameID = getGameID();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(playerNo + ". " + playerName);

        // increments number of pages by 1
        binding.addPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add score
                scorePoints++;
                // add shot
                myDB.addMatchEvent(SHOTID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                // add point
                myDB.addMatchEvent(POINTID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", String.valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("POINTADDED", "Point player " + playerNo);
            }
        });


        binding.addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add goal
                scoreGoals++;
                // add shot
                myDB.addMatchEvent(SHOTID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                // add goal
                myDB.addMatchEvent(GOALID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("GOALADDED", "Goal player " + playerNo);
            }
        });

        binding.addWide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add shot
                myDB.addMatchEvent(SHOTID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                // add wide
                myDB.addMatchEvent(WIDEID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("WIDEADDED", "Wide player " + playerNo);
            }
        });

        binding.addFoulWon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add foul
                myDB.addMatchEvent(FOULWONID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("FOULWONADDED", "Foul won player " + playerNo);
            }
        });

        binding.addFoulConceded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add foul
                myDB.addMatchEvent(FOULCONCID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("FOULCONADDED", "Foul conceded player " + playerNo);
            }
        });

        binding.addOwnKickoutWon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add kickout
                myDB.addMatchEvent(KICKOUTID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                // add kickout won
                myDB.addMatchEvent(OWNKICKOUTWONID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("OWNKICKWONADDED", "Kickout won player " + playerNo);
            }
        });

        binding.addOppKickoutWon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add kickout won
                myDB.addMatchEvent(OPPKICKOUTWONID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("OPPKICKWONADDED", "Kickout lost player " + playerNo);
            }
        });

        binding.addPostitiveTurnover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add positive turnover
                myDB.addMatchEvent(POSTURNOVERID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("POSTURNADDED", "Positive turnover player " + playerNo);
            }
        });

        binding.addNegTurnover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                // add negative turnover
                myDB.addMatchEvent(NEGTURNOVERID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(playerNo), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                intent.putExtra("points", String.valueOf(scorePoints));
                intent.putExtra("goals", String.valueOf(scoreGoals));
                startActivity(intent);
                Log.i("NEGTURNADDED", "Negative turnover player " + playerNo);
            }
        });

    }

    /**
     *
     */
    public void getAndSetIntentData() {
        if ( getIntent().hasExtra("squad_id") && getIntent().hasExtra("squad_name") && getIntent().hasExtra("player_name")
                && getIntent().hasExtra("player_no") && getIntent().hasExtra("points") && getIntent().hasExtra("goals")) {
            // getting data from intent
            timestamp = getIntent().getStringExtra("timestamp");
            squadID = getIntent().getStringExtra("squad_id");
            squadName = getIntent().getStringExtra("squad_name");
            playerName = getIntent().getStringExtra("player_name");
            playerNo = getIntent().getStringExtra("player_no");
            clickedSquadID = getIntent().getStringExtra("clickedSquadID");
            scorePoints = Integer.parseInt(getIntent().getStringExtra("points"));
            scoreGoals = Integer.parseInt(getIntent().getStringExtra("goals"));
        } else {
            Toast.makeText(this, "No Data here boss", Toast.LENGTH_SHORT).show();
        }
    }

    public int getGameID() {
        MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
        gameID = myDB.getMaxGameID();
        Toast.makeText(this, "gameID = " + gameID, Toast.LENGTH_SHORT).show();
        return gameID;
    }


}