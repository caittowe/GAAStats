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

    String clickedSquadID;
    String gameID;

    TextView p1Name, p2Name, p3Name, p4Name, p5Name, p6Name, p7Name, p8Name, p9Name, p10Name,
            p11Name, p12Name, p13Name, p14Name, p15Name;
    TextView p1Score, p2Score, p3Score, p4Score,
            p5Score, p6Score, p7Score, p8Score, p9Score, p10Score, p11Score, p12Score, p13Score,
            p14Score, p15Score;
    TextView p1Kickpass, p2Kickpass, p3Kickpass, p4Kickpass, p5Kickpass, p6Kickpass, p7Kickpass,
            p8Kickpass, p9Kickpass, p10Kickpass, p11Kickpass, p12Kickpass, p13Kickpass, p14Kickpass,
            p15Kickpass;

    int     p1ScoreCount, p2ScoreCount, p3ScoreCount, p4ScoreCount, p5ScoreCount, p6ScoreCount, p7ScoreCount,
            p8ScoreCount, p9ScoreCount, p10ScoreCount, p11ScoreCount, p12ScoreCount, p13ScoreCount,
            p14ScoreCount, p15ScoreCount;
    int     p1KickpassCount, p2KickpassCount, p3KickpassCount, p4KickpassCount,
            p5KickpassCount, p6KickpassCount, p7KickpassCount, p8KickpassCount, p9KickpassCount, p10KickpassCount,
            p11KickpassCount, p12KickpassCount, p13KickpassCount, p14KickpassCount, p15KickpassCount;


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

        p1Kickpass = findViewById(R.id.p1Kickpass);
        p2Kickpass = findViewById(R.id.p2Kickpass);
        p3Kickpass = findViewById(R.id.p3Kickpass);
        p4Kickpass = findViewById(R.id.p4Kickpass);
        p5Kickpass = findViewById(R.id.p5Kickpass);
        p6Kickpass = findViewById(R.id.p6Kickpass);
        p7Kickpass= findViewById(R.id.p7Kickpass);
        p8Kickpass = findViewById(R.id.p8Kickpass);
        p9Kickpass = findViewById(R.id.p9Kickpass);
        p10Kickpass = findViewById(R.id.p10Kickpass);
        p11Kickpass = findViewById(R.id.p11Kickpass);
        p12Kickpass = findViewById(R.id.p12Kickpass);
        p13Kickpass = findViewById(R.id.p13Kickpass);
        p14Kickpass = findViewById(R.id.p14Kickpass);
        p15Kickpass = findViewById(R.id.p15Kickpass);

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

        storeSetPlayerScoreData();
        storeSetPlayerKickpassData();

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

    public void storeSetPlayerScoreData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        p1ScoreCount  = myDB.showPlayerStatsCount("1" ,"1", gameID);
        p2ScoreCount  = myDB.showPlayerStatsCount("2" ,"1", gameID);
        p3ScoreCount  = myDB.showPlayerStatsCount("3" ,"1", gameID);
        p4ScoreCount  = myDB.showPlayerStatsCount("4" ,"1", gameID);
        p5ScoreCount  = myDB.showPlayerStatsCount("5" ,"1", gameID);
        p6ScoreCount  = myDB.showPlayerStatsCount("6" ,"1", gameID);
        p7ScoreCount  = myDB.showPlayerStatsCount("7" ,"1", gameID);
        p8ScoreCount  = myDB.showPlayerStatsCount("8" ,"1", gameID);
        p9ScoreCount  = myDB.showPlayerStatsCount("9" ,"1", gameID);
        p10ScoreCount  = myDB.showPlayerStatsCount("10" ,"1", gameID);
        p11ScoreCount  = myDB.showPlayerStatsCount("11" ,"1", gameID);
        p12ScoreCount  = myDB.showPlayerStatsCount("12" ,"1", gameID);
        p13ScoreCount  = myDB.showPlayerStatsCount("13" ,"1", gameID);
        p14ScoreCount  = myDB.showPlayerStatsCount("14" ,"1", gameID);
        p15ScoreCount  = myDB.showPlayerStatsCount("15" ,"1", gameID);

        p1Score.setText(String.valueOf(p1ScoreCount));
        p2Score.setText(String.valueOf(p2ScoreCount));
        p3Score.setText(String.valueOf(p3ScoreCount));
        p4Score.setText(String.valueOf(p4ScoreCount));
        p5Score.setText(String.valueOf(p5ScoreCount));
        p6Score.setText(String.valueOf(p6ScoreCount));
        p7Score.setText(String.valueOf(p7ScoreCount));
        p8Score.setText(String.valueOf(p8ScoreCount));
        p9Score.setText(String.valueOf(p9ScoreCount));
        p10Score.setText(String.valueOf(p10ScoreCount));
        p11Score.setText(String.valueOf(p11ScoreCount));
        p12Score.setText(String.valueOf(p12ScoreCount));
        p13Score.setText(String.valueOf(p13ScoreCount));
        p14Score.setText(String.valueOf(p14ScoreCount));
        p15Score.setText(String.valueOf(p15ScoreCount));

    }

    /**
     * fetches, stores and sets kickpass data for each player
     */
    public void storeSetPlayerKickpassData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        p1KickpassCount = myDB.showPlayerStatsCount("1" ,"2", gameID);
        p2KickpassCount  = myDB.showPlayerStatsCount("2" ,"2", gameID);
        p3KickpassCount  = myDB.showPlayerStatsCount("3" ,"2", gameID);
        p4KickpassCount  = myDB.showPlayerStatsCount("4" ,"2", gameID);
        p5KickpassCount = myDB.showPlayerStatsCount("5" ,"2", gameID);
        p6KickpassCount  = myDB.showPlayerStatsCount("6" ,"2", gameID);
        p7KickpassCount = myDB.showPlayerStatsCount("7" ,"2", gameID);
        p8KickpassCount  = myDB.showPlayerStatsCount("8" ,"2", gameID);
        p9KickpassCount  = myDB.showPlayerStatsCount("9" ,"2", gameID);
        p10KickpassCount  = myDB.showPlayerStatsCount("10" ,"2", gameID);
        p11KickpassCount  = myDB.showPlayerStatsCount("11" ,"2", gameID);
        p12KickpassCount  = myDB.showPlayerStatsCount("12" ,"2", gameID);
        p13KickpassCount = myDB.showPlayerStatsCount("13" ,"2", gameID);
        p14KickpassCount  = myDB.showPlayerStatsCount("14" ,"2", gameID);
        p15KickpassCount  = myDB.showPlayerStatsCount("15" ,"2", gameID);

        p1Kickpass.setText(String.valueOf(p1KickpassCount));
        p2Kickpass.setText(String.valueOf(p2KickpassCount));
        p3Kickpass.setText(String.valueOf(p3KickpassCount));
        p4Kickpass.setText(String.valueOf(p4KickpassCount));
        p5Kickpass.setText(String.valueOf(p5KickpassCount));
        p6Kickpass.setText(String.valueOf(p6KickpassCount));
        p7Kickpass.setText(String.valueOf(p7KickpassCount));
        p8Kickpass.setText(String.valueOf(p8KickpassCount));
        p9Kickpass.setText(String.valueOf(p9KickpassCount));
        p10Kickpass.setText(String.valueOf(p10KickpassCount));
        p11Kickpass.setText(String.valueOf(p11KickpassCount));
        p12Kickpass.setText(String.valueOf(p12KickpassCount));
        p13Kickpass.setText(String.valueOf(p13KickpassCount));
        p14Kickpass.setText(String.valueOf(p14KickpassCount));
        p15Kickpass.setText(String.valueOf(p15KickpassCount));

    }


}