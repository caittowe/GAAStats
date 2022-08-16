package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.statsgaa.databinding.ActivityShowGameStatsBinding;

import java.util.ArrayList;

public class ShowGameStats extends AppCompatActivity {

    ActivityShowGameStatsBinding binding;

    ArrayList<String> playerNames, playerNos, statID;

    String clickedSquadID;
    String gameID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowGameStatsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getIntentData();

        playerNames = new ArrayList<>();
        playerNos = new ArrayList<>();
        statID = new ArrayList<>();

        binding.topScorers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowGameStats.this, ShowScoresDesc.class);
                intent.putExtra("gameID", gameID);
                intent.putExtra("squadID", clickedSquadID);
                startActivity(intent);
            }
        });

        storeDataInArrays();
        storeSetShotsData();
        storeSetScoreData();
        storeSetWideData();
        storeSetPosTurnoverData();
        storeSetNegTurnoverData();
        storeSetFoulWonData();
        storeSetFoulConcData();
        storeSetOwnKickoutWonData();
        storeSetOppKickoutWonData();

        binding.p1Name.setText(playerNos.get(0) + ". " + playerNames.get(0));
        binding.p2Name.setText(playerNos.get(1) + ". " + playerNames.get(1));
        binding.p3Name.setText(playerNos.get(2) + ". " + playerNames.get(2));
        binding.p4Name.setText(playerNos.get(3) + ". " + playerNames.get(3));
        binding.p5Name.setText(playerNos.get(4) + ". " + playerNames.get(4));
        binding.p6Name.setText(playerNos.get(5) + ". " + playerNames.get(5));
        binding.p7Name.setText(playerNos.get(6) + ". " + playerNames.get(6));
        binding.p8Name.setText(playerNos.get(7) + ". " + playerNames.get(7));
        binding.p9Name.setText(playerNos.get(8) + ". " + playerNames.get(8));
        binding.p10Name.setText(playerNos.get(9) + ". " + playerNames.get(9));
        binding.p11Name.setText(playerNos.get(10) + ". " + playerNames.get(10));
        binding.p12Name.setText(playerNos.get(11) + ". " + playerNames.get(11));
        binding.p13Name.setText(playerNos.get(12) + ". " + playerNames.get(12));
        binding.p14Name.setText(playerNos.get(13) + ". " + playerNames.get(13));
        binding.p15Name.setText(playerNos.get(14) + ". " + playerNames.get(14));

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

    /**
     * fetches stores and sets textview to shot data
     */
    public void storeSetShotsData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1Shots.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p2Shots.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p3Shots.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p4Shots.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p5Shots.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p6Shots.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p7Shots.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p8Shots.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p9Shots.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p10Shots.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p11Shots.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p12Shots.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p13Shots.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p14Shots.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.SHOTID),gameID)));
        binding.p15Shots.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.SHOTID),gameID)));
    }

    /**
     * fetches stores and sets textview to score data
     */
    public void storeSetScoreData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1Scores.setText(myDB.showPlayerStatsCount("1", String.valueOf(EnterStat.GOALID), gameID) + " - " + myDB.showPlayerStatsCount("1", String.valueOf(EnterStat.POINTID), gameID));
        binding.p2Scores.setText(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.POINTID),gameID));
        binding.p3Scores.setText(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.POINTID),gameID));
        binding.p4Scores.setText(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.POINTID),gameID));
        binding.p5Scores.setText(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.POINTID),gameID));
        binding.p6Scores.setText(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.POINTID),gameID));
        binding.p7Scores.setText(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.POINTID),gameID));
        binding.p8Scores.setText(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.POINTID),gameID));
        binding.p9Scores.setText(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.POINTID),gameID));
        binding.p10Scores.setText(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.POINTID),gameID));
        binding.p11Scores.setText(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.POINTID),gameID));
        binding.p12Scores.setText(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.POINTID),gameID));
        binding.p13Scores.setText(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.POINTID),gameID));
        binding.p14Scores.setText(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.POINTID),gameID));
        binding.p15Scores.setText(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.GOALID),gameID)+" - "+myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.POINTID),gameID));

    }

    /**
     * fetches stores and sets textview to wide data
     */
    public void storeSetWideData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1Wide.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p2Wide.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p3Wide.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p4Wide.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p5Wide.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p6Wide.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p7Wide.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p8Wide.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p9Wide.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p10Wide.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p11Wide.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p12Wide.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p13Wide.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p14Wide.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.WIDEID),gameID)));
        binding.p15Wide.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.WIDEID),gameID)));
    }

    /**
     * fetches, stores and sets positive turnover data
     */
    public void storeSetPosTurnoverData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p2PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p3PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p4PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p5PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p6PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p7PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p8PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p9PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p10PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p11PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p12PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p13PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p14PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
        binding.p15PositiveTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.POSTURNOVERID),gameID)));
    }

    /**
     * fetches, stores and sets negative turnover data
     */
    public void storeSetNegTurnoverData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p2NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p3NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p4NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p5NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p6NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p7NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p8NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p9NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p10NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p11NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p12NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p13NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p14NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
        binding.p15NegativeTurnover.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.NEGTURNOVERID),gameID)));
    }

    /**
     * fetches, stores and sets foul won data
     */
    public void storeSetFoulWonData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p2FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p3FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p4FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p5FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p6FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p7FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p8FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p9FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p10FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p11FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p12FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p13FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p14FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.FOULWONID),gameID)));
        binding.p15FoulWon.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.FOULWONID),gameID)));
    }

    /**
     * fetches, stores and sets foul conceded data
     */
    public void storeSetFoulConcData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p2FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p3FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p4FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p5FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p6FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p7FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p8FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p9FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p10FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p11FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p12FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p13FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p14FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.FOULCONCID),gameID)));
        binding.p15FoulConceded.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.FOULCONCID),gameID)));
    }


    /**
     * fetches, stores and sets own kickout won data
     */
    public void storeSetOwnKickoutWonData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p2OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p3OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p4OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p5OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p6OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p7OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p8OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p9OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p10OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p11OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p12OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p13OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p14OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
        binding.p15OwnKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.OWNKICKOUTWONID),gameID)));
    }

    /**
     * fetches, stores and sets foul won data
     */
    public void storeSetOppKickoutWonData(){
        MyDatabaseHelper myDB = new MyDatabaseHelper(ShowGameStats.this);
        binding.p1OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("1",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p2OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("2",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p3OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("3",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p4OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("4",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p5OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("5",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p6OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("6",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p7OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("7",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p8OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("8",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p9OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("9",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p10OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("10",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p11OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("11",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p12OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("12",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p13OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("13",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p14OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("14",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
        binding.p15OppKickoutWon.setText(String.valueOf(myDB.showPlayerStatsCount("15",String.valueOf(EnterStat.OPPKICKOUTWONID),gameID)));
    }




}