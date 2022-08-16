package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowScoresDesc extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    ArrayList<String> playerNames, scorersDesc, playerNamesOrder, playerNosOrder, playerScoresOrder, playerPoints, playerGoals;
    CustomAdapterScoresList customAdapter;
    String gameID, squadID;
    String pointID = String.valueOf(EnterStat.POINTID);
    String goalID = String.valueOf(EnterStat.GOALID);
    String p1Points, p1Goals, p1Total, p2Points, p2Goals, p2Total, p3Points, p3Goals, p3Total, p4Points, p4Goals, p4Total;
    String p5Points, p5Goals, p5Total, p6Points, p6Goals, p6Total, p7Points, p7Goals, p7Total, p8Points, p8Goals, p8Total;
    String p9Points, p9Goals, p9Total, p10Points, p10Goals,p10Total, p11Points, p11Goals, p11Total, p12Points, p12Goals, p12Total;
    String p13Points, p13Goals, p13Total, p14Points, p14Goals, p14Total, p15Points, p15Goals, p15Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_scores_desc);

        recyclerView = findViewById(R.id.scoresRecycler);

        myDB = new MyDatabaseHelper(ShowScoresDesc.this);

        playerNames = new ArrayList<>();
        scorersDesc = new ArrayList<>();
        playerNamesOrder = new ArrayList<>();
        playerNosOrder = new ArrayList<>();
        playerPoints = new ArrayList<>();
        playerGoals = new ArrayList<>();
        playerScoresOrder = new ArrayList<>();

        // get intent data
        getIntentData();
        storeDataInArrays();
        addSetScores();
        returnScorersDesc();



        customAdapter = new CustomAdapterScoresList(ShowScoresDesc.this, this, playerNamesOrder, playerNosOrder, playerGoals, playerPoints, playerScoresOrder);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowScoresDesc.this));

    }

    public void getIntentData() {
        if (getIntent().hasExtra("gameID")) {
            gameID = getIntent().getStringExtra("gameID");
            Log.i("GAMEID", "game id =  " + gameID);
            squadID = getIntent().getStringExtra("squadID");
            Log.i("SQUADID", "squad id =  " + squadID);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Stores data entered into array lists
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
    public void addSetScores(){
        p1Points = String.valueOf(myDB.showPlayerStatsCount("1", pointID, gameID));
        p1Goals = String.valueOf(myDB.showPlayerStatsCount("1", goalID, gameID));
        p1Total =  String.valueOf((Integer.parseInt(p1Points)+(3*(Integer.parseInt(p1Goals)))));
        myDB.addTopScorers(gameID, "1",playerNames.get(0),p1Goals, p1Points, p1Total);

        p2Points = String.valueOf(myDB.showPlayerStatsCount("2", pointID, gameID));
        p2Goals = String.valueOf(myDB.showPlayerStatsCount("2", goalID, gameID));
        p2Total = String.valueOf((Integer.parseInt(p2Points)+(3*(Integer.parseInt(p2Goals)))));
        myDB.addTopScorers(gameID, "2",playerNames.get(1),p2Goals, p2Points, p2Total);

        p3Points = String.valueOf(myDB.showPlayerStatsCount("3", pointID, gameID));
        p3Goals = String.valueOf(myDB.showPlayerStatsCount("3", goalID, gameID));
        p2Total = String.valueOf((Integer.parseInt(p2Points)+(3*(Integer.parseInt(p3Goals)))));
        myDB.addTopScorers(gameID, "3",playerNames.get(2),p3Goals, p3Points, p3Total);

        p4Points = String.valueOf(myDB.showPlayerStatsCount("4", pointID, gameID));
        p4Goals = String.valueOf(myDB.showPlayerStatsCount("4", goalID, gameID));
        p4Total = String.valueOf((Integer.parseInt(p4Points)+(3*(Integer.parseInt(p4Goals)))));
        myDB.addTopScorers(gameID, "4",playerNames.get(3),p4Goals, p4Points, p4Total);

        p5Points = String.valueOf(myDB.showPlayerStatsCount("5", pointID, gameID));
        p5Goals = String.valueOf(myDB.showPlayerStatsCount("5", goalID, gameID));
        p5Total = String.valueOf((Integer.parseInt(p5Points)+(3*(Integer.parseInt(p5Goals)))));
        myDB.addTopScorers(gameID, "5",playerNames.get(4),p5Goals, p5Points, p5Total);

        p6Points = String.valueOf(myDB.showPlayerStatsCount("6", pointID, gameID));
        p6Goals = String.valueOf(myDB.showPlayerStatsCount("6", goalID, gameID));
        p6Total = String.valueOf((Integer.parseInt(p6Points)+(3*(Integer.parseInt(p6Goals)))));
        myDB.addTopScorers(gameID, "6",playerNames.get(5),p6Goals, p6Points, p6Total);

        p7Points = String.valueOf(myDB.showPlayerStatsCount("7", pointID, gameID));
        p7Goals = String.valueOf(myDB.showPlayerStatsCount("7", goalID, gameID));
        p7Total = String.valueOf((Integer.parseInt(p7Points)+(3*(Integer.parseInt(p7Goals)))));
        myDB.addTopScorers(gameID, "7",playerNames.get(6),p7Goals, p7Points, p7Total);

        p8Points = String.valueOf(myDB.showPlayerStatsCount("8", pointID, gameID));
        p8Goals = String.valueOf(myDB.showPlayerStatsCount("8", goalID, gameID));
        p8Total = String.valueOf((Integer.parseInt(p8Points)+(3*(Integer.parseInt(p8Goals)))));
        myDB.addTopScorers(gameID, "8",playerNames.get(7),p8Goals, p8Points, p8Total);

        p9Points = String.valueOf(myDB.showPlayerStatsCount("9", pointID, gameID));
        p9Goals = String.valueOf(myDB.showPlayerStatsCount("9", goalID, gameID));
        p9Total = String.valueOf((Integer.parseInt(p9Points)+(3*(Integer.parseInt(p9Goals)))));
        myDB.addTopScorers(gameID, "9",playerNames.get(8),p9Goals, p9Points, p9Total);

        p10Points = String.valueOf(myDB.showPlayerStatsCount("10", pointID, gameID));
        p10Goals = String.valueOf(myDB.showPlayerStatsCount("10", goalID, gameID));
        p10Total = String.valueOf((Integer.parseInt(p10Points)+(3*(Integer.parseInt(p10Goals)))));
        myDB.addTopScorers(gameID, "10",playerNames.get(9),p10Goals, p10Points, p10Total);

        p11Points = String.valueOf(myDB.showPlayerStatsCount("11", pointID, gameID));
        p11Goals = String.valueOf(myDB.showPlayerStatsCount("11", goalID, gameID));
        p11Total = String.valueOf((Integer.parseInt(p11Points)+(3*(Integer.parseInt(p11Goals)))));
        myDB.addTopScorers(gameID, "11",playerNames.get(10),p11Goals, p11Points, p11Total);

        p12Points = String.valueOf(myDB.showPlayerStatsCount("12", pointID, gameID));
        p12Goals = String.valueOf(myDB.showPlayerStatsCount("12", goalID, gameID));
        p12Total = String.valueOf((Integer.parseInt(p12Points)+(3*(Integer.parseInt(p12Goals)))));
        myDB.addTopScorers(gameID, "12",playerNames.get(11),p12Goals, p12Points, p12Total);

        p13Points = String.valueOf(myDB.showPlayerStatsCount("13", pointID, gameID));
        p13Goals = String.valueOf(myDB.showPlayerStatsCount("13", goalID, gameID));
        p13Total = String.valueOf((Integer.parseInt(p13Points)+(3*(Integer.parseInt(p13Goals)))));
        myDB.addTopScorers(gameID, "13",playerNames.get(12),p13Goals, p13Points, p13Total);

        p14Points = String.valueOf(myDB.showPlayerStatsCount("14", pointID, gameID));
        p14Goals = String.valueOf(myDB.showPlayerStatsCount("14", goalID, gameID));
        p14Total = String.valueOf((Integer.parseInt(p14Points)+(3*(Integer.parseInt(p14Goals)))));
        myDB.addTopScorers(gameID, "14",playerNames.get(13),p14Goals, p14Points, p14Total);

        p15Points = String.valueOf(myDB.showPlayerStatsCount("15", pointID, gameID));
        p15Goals = String.valueOf(myDB.showPlayerStatsCount("15", goalID, gameID));
        p15Total = String.valueOf((Integer.parseInt(p15Points)+(3*(Integer.parseInt(p15Goals)))));
        myDB.addTopScorers(gameID, "15",playerNames.get(14),p15Goals, p15Points, p15Total);
    }

    /**
     * adds top scorers to an array list in order
     */
    public void returnScorersDesc(){
        Cursor cursorPlayer = myDB.returnScorersDesc(gameID);
        if (cursorPlayer.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursorPlayer.moveToNext()) {
                playerNamesOrder.add(cursorPlayer.getString(0));
                playerNosOrder.add(cursorPlayer.getString(1));
                playerGoals.add(cursorPlayer.getString(2));
                playerPoints.add(cursorPlayer.getString(3));
                playerScoresOrder.add(cursorPlayer.getString(4));
            }
        }

    }
}