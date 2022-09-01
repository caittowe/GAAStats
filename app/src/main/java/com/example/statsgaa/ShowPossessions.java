package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowPossessions extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> playerNames, playerNamesOrder, playerNosOrder, playerPossessionsOrder;
    CustomAdapterPossessionList customAdapter;
    String gameID, squadID, possessionID;
    String p1Possessions, p2Possessions,p3Possessions,p4Possessions,p5Possessions,p6Possessions,p7Possessions,
    p8Possessions,p9Possessions,p10Possessions,p11Possessions,p12Possessions,p13Possessions,p14Possessions,p15Possessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_possessions);

        recyclerView = findViewById(R.id.possessionsRecycler);
        possessionID = String.valueOf(EnterStat.POSSESSIONID);

        myDB = new MyDatabaseHelper(ShowPossessions.this);
        playerNames = new ArrayList<>();
        playerNamesOrder = new ArrayList<>();
        playerNosOrder = new ArrayList<>();
        playerPossessionsOrder = new ArrayList<>();

        // get intent data
        getIntentData();
        storeDataInArrays();
        // add and fetch db data
        addSetPossessions();
        returnPossessionsDesc();

        // set custom adapter and recycler views
        customAdapter = new CustomAdapterPossessionList(ShowPossessions.this, this, playerNamesOrder, playerNosOrder, playerPossessionsOrder);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowPossessions.this));

    }

    /**
     * gets intent data from ShowGameStats.java
     */
    public void getIntentData() {
        if (getIntent().hasExtra("gameID")) {
            gameID = getIntent().getStringExtra("gameID");
            Log.i("GAMEID", "game id =  " + gameID);
            squadID = getIntent().getStringExtra("squadID");
            Log.i("SQUADID", "squad id =  " + squadID);
        } else {
//            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * gets player names from database using the squad id and adds to array
     */
    public void storeDataInArrays() {
        Cursor cursor = myDB.readAllClickedSquadData(squadID);
        if (cursor.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                playerNames.add(cursor.getString(3));
            }
        }
    }

    /**
     * gets possession count for each player from the database and adds it to the 'possession' table
     */
    public void addSetPossessions() {
        p1Possessions = String.valueOf(myDB.showPlayerStatsCount("1", possessionID, gameID));
        p2Possessions = String.valueOf(myDB.showPlayerStatsCount("2", possessionID, gameID));
        p3Possessions = String.valueOf(myDB.showPlayerStatsCount("3", possessionID, gameID));
        p4Possessions = String.valueOf(myDB.showPlayerStatsCount("4", possessionID, gameID));
        p5Possessions = String.valueOf(myDB.showPlayerStatsCount("5", possessionID, gameID));
        p6Possessions = String.valueOf(myDB.showPlayerStatsCount("6", possessionID, gameID));
        p7Possessions = String.valueOf(myDB.showPlayerStatsCount("7", possessionID, gameID));
        p8Possessions = String.valueOf(myDB.showPlayerStatsCount("8", possessionID, gameID));
        p9Possessions = String.valueOf(myDB.showPlayerStatsCount("9", possessionID, gameID));
        p10Possessions = String.valueOf(myDB.showPlayerStatsCount("10", possessionID, gameID));
        p11Possessions = String.valueOf(myDB.showPlayerStatsCount("11", possessionID, gameID));
        p12Possessions = String.valueOf(myDB.showPlayerStatsCount("12", possessionID, gameID));
        p13Possessions = String.valueOf(myDB.showPlayerStatsCount("13", possessionID, gameID));
        p14Possessions = String.valueOf(myDB.showPlayerStatsCount("14", possessionID, gameID));
        p15Possessions = String.valueOf(myDB.showPlayerStatsCount("15", possessionID, gameID));

        myDB.addTopPossessions(gameID, "1", playerNames.get(0), p1Possessions);
        myDB.addTopPossessions(gameID, "2", playerNames.get(1), p2Possessions);
        myDB.addTopPossessions(gameID, "3", playerNames.get(2), p3Possessions);
        myDB.addTopPossessions(gameID, "4", playerNames.get(3), p4Possessions);
        myDB.addTopPossessions(gameID, "5", playerNames.get(4), p5Possessions);
        myDB.addTopPossessions(gameID, "6", playerNames.get(5), p6Possessions);
        myDB.addTopPossessions(gameID, "7", playerNames.get(6), p7Possessions);
        myDB.addTopPossessions(gameID, "8", playerNames.get(7), p8Possessions);
        myDB.addTopPossessions(gameID, "9", playerNames.get(8), p8Possessions);
        myDB.addTopPossessions(gameID, "10", playerNames.get(9), p10Possessions);
        myDB.addTopPossessions(gameID, "11", playerNames.get(10), p11Possessions);
        myDB.addTopPossessions(gameID, "12", playerNames.get(11), p12Possessions);
        myDB.addTopPossessions(gameID, "13", playerNames.get(12), p13Possessions);
        myDB.addTopPossessions(gameID, "14", playerNames.get(13), p14Possessions);
        myDB.addTopPossessions(gameID, "15", playerNames.get(14), p15Possessions);
    }

    /**
     * returns the possessions for each player in order desc and adds results to array lists
     */
    public void returnPossessionsDesc(){
        Cursor cursorPlayer = myDB.returnPossessionsDesc(gameID);
        if (cursorPlayer.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursorPlayer.moveToNext()) {
                playerNamesOrder.add(cursorPlayer.getString(0));
                playerNosOrder.add(cursorPlayer.getString(1));
                playerPossessionsOrder.add(cursorPlayer.getString(2));;
            }
        }
    }
}