package com.example.statsgaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnterStat extends AppCompatActivity {

    private Button addScore, addKickpass, addFistpass;

    String squad_table_id, squad_id, squad_name, player_name, player_no, clickedSquadID;
    int scoreID = 1;
    int kickpassID = 2;
    int handpassID = 3;
    String timestamp;
    int gameID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stat);

        addScore = findViewById(R.id.addScore);
        addKickpass = findViewById(R.id.addKickpass);
        addFistpass = findViewById(R.id.addFirstpass);

        // first we call this
        getAndSetIntentData();
        gameID = getGameID();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(player_no + ". " + player_name);

        // increments number of pages by 1
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(scoreID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(player_no), timestamp);
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", String.valueOf(gameID));
                startActivity(intent);
                Log.i("SCOREADDED", "Score added player "+player_no);
            }
        });

        addFistpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                Intent intent = new Intent(EnterStat.this, GameStart.class);
                myDB.addMatchEvent(handpassID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(player_no), timestamp);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id));
                intent.putExtra("squad_id", toString().valueOf(squad_id));
                intent.putExtra("squad_name", toString().valueOf(squad_name));
                intent.putExtra("player_name", toString().valueOf(player_name));
                intent.putExtra("player_no", toString().valueOf(player_no));
                intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
                intent.putExtra("gameID", toString().valueOf(gameID));
                startActivity(intent);
                Log.i("FISTADDED", "Fistpass added player "+player_no);
            }
        });

    addKickpass.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
            Intent intent = new Intent(EnterStat.this, GameStart.class);
            myDB.addMatchEvent(kickpassID, gameID, Integer.parseInt(clickedSquadID), Integer.parseInt(player_no), timestamp);
            intent.putExtra("squad_table_id", toString().valueOf(squad_table_id));
            intent.putExtra("squad_id", toString().valueOf(squad_id));
            intent.putExtra("squad_name", toString().valueOf(squad_name));
            intent.putExtra("player_name", toString().valueOf(player_name));
            intent.putExtra("player_no", toString().valueOf(player_no));
            intent.putExtra("clicked_squad_id", toString().valueOf(clickedSquadID));
            intent.putExtra("gameID", toString().valueOf(gameID));
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
            timestamp = getIntent().getStringExtra("timestamp");
            squad_table_id = getIntent().getStringExtra("squad_table_id");
            squad_id = getIntent().getStringExtra("squad_id");
            squad_name = getIntent().getStringExtra("squad_name");
            player_name = getIntent().getStringExtra("player_name");
            player_no = getIntent().getStringExtra("player_no");
            clickedSquadID = getIntent().getStringExtra("clickedSquadID");

        } else {
            Toast.makeText(this, "No Data here boss", Toast.LENGTH_SHORT).show();
        }
    }

    public int getGameID(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
        gameID = myDB.getMaxGameID();
        Toast.makeText(this, "gameID = "+gameID, Toast.LENGTH_SHORT).show();
        return gameID;
    }


}