package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowGameStats extends AppCompatActivity {


    ArrayList<String> playerNames, playerNos, statID;
    TextView p1Name, p2Name, p3Name, p4Name, p5Name, p6Name, p7Name, p8Name, p9Name, p10Name,
            p11Name, p12Name, p13Name, p14Name, p15Name, p1Score, p2Score, p3Score, p4Score,
            p5Score, p6Score, p7Score, p8Score, p9Score, p10Score, p11Score, p12Score, p13Score,
            p14Score, p15Score;

    String clickedSquadID;
    String gameID;
    int p1ScoreCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_game_stats);

        p1Name = findViewById(R.id.p1Name);
        p2Name = findViewById(R.id.p2Name);
        p3Name = findViewById(R.id.p3Name);
        p4Name = findViewById(R.id.p4Name);
        p5Name = findViewById(R.id.p5Name);
        p6Name = findViewById(R.id.p6Name);
        p7Name = findViewById(R.id.p7Name);
        p8Name = findViewById(R.id.p8Name);
        p9Name = findViewById(R.id.p9Name);
        p10Name = findViewById(R.id.p10Name);
        p11Name = findViewById(R.id.p11Name);
        p12Name = findViewById(R.id.p12Name);
        p13Name = findViewById(R.id.p13Name);
        p14Name = findViewById(R.id.p14Name);
        p15Name = findViewById(R.id.p15Name);

        p1Score = findViewById(R.id.p1Score);
        p2Score = findViewById(R.id.p2Score);
        p3Score = findViewById(R.id.p3Score);
        p4Score = findViewById(R.id.p4Score);
        p5Score = findViewById(R.id.p5Score);
        p6Score = findViewById(R.id.p6Score);
        p7Score = findViewById(R.id.p7Score);
        p8Score = findViewById(R.id.p8Score);
        p9Score = findViewById(R.id.p9Score);
        p10Score = findViewById(R.id.p10Score);
        p11Score = findViewById(R.id.p11Score);
        p12Score = findViewById(R.id.p12Score);
        p13Score = findViewById(R.id.p13Score);
        p14Score = findViewById(R.id.p14Score);
        p15Score = findViewById(R.id.p15Score);

        getIntentData();

        playerNames = new ArrayList<>();
        playerNos = new ArrayList<>();
        statID = new ArrayList<>();

        storeDataInArrays();

        p1Name.setText(playerNos.get(0) + ". " + playerNames.get(0));
        p2Name.setText(playerNos.get(1) + ". " + playerNames.get(1));
        p3Name.setText(playerNos.get(2) + ". " + playerNames.get(2));
        p4Name.setText(playerNos.get(3) + ". " + playerNames.get(3));
        p5Name.setText(playerNos.get(4) + ". " + playerNames.get(4));
        p6Name.setText(playerNos.get(5) + ". " + playerNames.get(5));
        p7Name.setText(playerNos.get(6) + ". " + playerNames.get(6));
        p8Name.setText(playerNos.get(7) + ". " + playerNames.get(7));
        p9Name.setText(playerNos.get(8) + ". " + playerNames.get(8));
        p10Name.setText(playerNos.get(9) + ". " + playerNames.get(9));
        p11Name.setText(playerNos.get(10) + ". " + playerNames.get(10));
        p12Name.setText(playerNos.get(11) + ". " + playerNames.get(11));
        p13Name.setText(playerNos.get(12) + ". " + playerNames.get(12));
        p14Name.setText(playerNos.get(13) + ". " + playerNames.get(13));
        p15Name.setText(playerNos.get(14) + ". " + playerNames.get(14));

        storePlayerStatData();

        p1Score.setText(String.valueOf(p1ScoreCount));

    }


    /**
     * gets match id
     */
    public void getIntentData() {
        if (getIntent().hasExtra("squadID") && (getIntent().hasExtra("gameID"))) {
            clickedSquadID = getIntent().getStringExtra("squadID");
            gameID = getIntent().getStringExtra("gameID");
            Log.i("GOTSQUAD", "getIntentData: squad id =  " + clickedSquadID);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }




    /**
     * Stores data entered into array lists
     */
    public void storeDataInArrays() {
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        Cursor cursorPlayer = myDB.readAllClickedSquadData(clickedSquadID);
        if (cursorPlayer.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursorPlayer.moveToNext()) {
                playerNames.add(cursorPlayer.getString(3));
                playerNos.add(cursorPlayer.getString(4));

            }
        }
    }

    public void storePlayerStatData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        p1ScoreCount  = myDB.showPlayerStatsCount("1" ,"1", gameID);
        Log.i("SCORECOUNT","stat count for p1 = "+p1ScoreCount);

    }


}