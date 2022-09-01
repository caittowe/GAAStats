package com.example.statsgaa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class GameStart extends AppCompatActivity {

    private static final long START_TIME_MILLISECONDS = 3600000;

    MyDatabaseHelper myDB;
    String gameID, clickedSquadID, pointsScored, goalsScored;
    ArrayList<String> squadTableIDs;
    ArrayList<String> squadIDs;
    ArrayList<String> squadNames;
    ArrayList<String> playerNames;
    ArrayList<String> playerNos;
    private TextView tvCountdownTimer;
    public TextView showScore;
    private Button btnStartPause;
    private Button btnEndGame;
    private CountDownTimer countdownTimer;
    private boolean timerRunning;
    private long timeLeftMillis;
    private long endTime;
    Context context;
    Button btnPlayer1, btnPlayer2, btnPlayer3, btnPlayer4, btnPlayer5, btnPlayer6, btnPlayer7, btnPlayer8, btnPlayer9, btnPlayer10, btnPlayer11, btnPlayer12, btnPlayer13, btnPlayer14, btnPlayer15;

    /**
     * displays the details entered from the dialog
     * calls storedatainarrays method
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);


        context = this;
        showScore = findViewById(R.id.showScore);
        tvCountdownTimer = findViewById(R.id.text_view_countdown);
        btnStartPause = findViewById(R.id.button_start_pause);
        btnEndGame = findViewById(R.id.button_reset);

        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        btnEndGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(GameStart.this);
                builder.setTitle("End Game")
                        .setCancelable(true)
                        .setMessage("Are you sure you want to end the game?")
                        .setPositiveButton("End", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(GameStart.this, ShowGameStats.class);
                                intent.putExtra("squadID", clickedSquadID);
                                intent.putExtra("gameID", gameID);
                                countdownTimer.cancel();
                                resetTimer();
                                SharedPreferences settings = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
                                settings.edit().clear().commit();
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null);
                builder.create();
                builder.show();
            }
        });


        myDB = new MyDatabaseHelper(GameStart.this);
        squadTableIDs = new ArrayList<>();
        squadIDs = new ArrayList<>();
        squadNames = new ArrayList<>();
        playerNames = new ArrayList<>();
        playerNos = new ArrayList<>();

        getIntentData();
        storeDataInArrays();

        btnPlayer1 = findViewById(R.id.btnPlayer1);
        btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 1, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(0)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(0)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(0)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(0)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);
            }
        });

        btnPlayer2 = findViewById(R.id.btnPlayer2);
        btnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 2, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(1)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(1)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(1)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(1)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(1)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer3 = findViewById(R.id.btnPlayer3);
        btnPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 3, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(2)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(2)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(2)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(2)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(2)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer4 = findViewById(R.id.btnPlayer4);
        btnPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 4, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(3)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(3)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(3)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(3)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(3)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer5 = findViewById(R.id.btnPlayer5);
        btnPlayer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 5, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(4)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(4)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(4)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(4)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(4)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer6 = findViewById(R.id.btnPlayer6);
        btnPlayer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 6, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(5)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(5)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(5)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(5)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(5)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer7 = findViewById(R.id.btnPlayer7);
        btnPlayer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 7, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(6)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(6)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(6)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(6)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(6)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer8 = findViewById(R.id.btnPlayer8);
        btnPlayer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 8, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(7)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(7)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(7)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(7)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(7)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer9 = findViewById(R.id.btnPlayer9);
        btnPlayer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 9, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(8)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(8)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(8)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(8)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(8)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer10 = findViewById(R.id.btnPlayer10);
        btnPlayer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 10, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(9)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(9)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(9)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(9)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(9)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer11 = findViewById(R.id.btnPlayer11);
        btnPlayer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 11, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(10)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(10)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(10)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(10)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(10)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer12 = findViewById(R.id.btnPlayer12);
        btnPlayer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 12, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(11)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(11)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(11)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(11)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(11)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer13 = findViewById(R.id.btnPlayer13);
        btnPlayer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 13, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(12)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(12)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(12)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(12)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(12)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer14 = findViewById(R.id.btnPlayer14);
        btnPlayer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 14, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(13)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(13)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(13)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(13)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(13)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

        btnPlayer15 = findViewById(R.id.btnPlayer15);
        btnPlayer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.addMatchEvent(EnterStat.POSSESSIONID, Integer.valueOf(gameID), Integer.valueOf(clickedSquadID), 15, tvCountdownTimer.getText().toString());
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", tvCountdownTimer.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squadTableIDs.get(14)));
                intent.putExtra("squad_id", toString().valueOf(squadIDs.get(14)));
                intent.putExtra("squad_name", toString().valueOf(squadNames.get(14)));
                intent.putExtra("player_name", toString().valueOf(playerNames.get(14)));
                intent.putExtra("player_no", toString().valueOf(playerNos.get(14)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

    }


    private void startTimer() {
        endTime = System.currentTimeMillis() + timeLeftMillis;
        countdownTimer = new CountDownTimer(timeLeftMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timerRunning = false;
                updateButtons();
            }
        }.start();

        timerRunning = true;
        updateButtons();
    }

    private void pauseTimer() {
        countdownTimer.cancel();
        timerRunning = false;
        updateButtons();
    }

    private void resetTimer() {
        timeLeftMillis = START_TIME_MILLISECONDS;
        updateCountDownText();
        updateButtons();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftMillis / 1000) / 60;
        int seconds = (int) (timeLeftMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tvCountdownTimer.setText(timeLeftFormatted);
    }

    private void updateButtons() {
        if (timerRunning) {
            btnEndGame.setVisibility(View.INVISIBLE);
            btnStartPause.setText("Pause");
        } else {
            btnStartPause.setText("Start");

            if (timeLeftMillis < 1000) {
                btnStartPause.setVisibility(View.INVISIBLE);
            } else {
                btnStartPause.setVisibility(View.VISIBLE);
            }

            if (timeLeftMillis < START_TIME_MILLISECONDS) {
                btnEndGame.setVisibility(View.VISIBLE);
            } else {
                btnEndGame.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", timeLeftMillis);
        editor.putBoolean("timerRunning", timerRunning);
        editor.putLong("endTime", endTime);

        editor.apply();

        if (countdownTimer != null) {
            countdownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        timeLeftMillis = prefs.getLong("millisLeft", START_TIME_MILLISECONDS);
        timerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateButtons();

        if (timerRunning) {
            endTime = prefs.getLong("endTime", 0);
            timeLeftMillis = endTime - System.currentTimeMillis();

            if (timeLeftMillis < 0) {
                timeLeftMillis = 0;
                timerRunning = false;
                updateCountDownText();
                updateButtons();
            } else {
                startTimer();
            }
        }
    }


    /**
     * gets squad id of the squad that was clicked ont
     */
    public void getIntentData() {
        clickedSquadID = getIntent().getStringExtra("clicked_squad_id");
        gameID = getIntent().getStringExtra("gameID");
        storeDataInArrays();
        if (getIntent().hasExtra("points") && getIntent().hasExtra("goals") ) {
            // getting data from intent
            pointsScored = getIntent().getStringExtra("points");
            goalsScored = getIntent().getStringExtra("goals");
            showScore.setText("Score: "+goalsScored+" - "+pointsScored);
            Log.i("GOTSQUAD", "getIntentData: squad id =  " + clickedSquadID);
        } else {
            pointsScored = String.valueOf(0);
            goalsScored = String.valueOf(0);
            showScore.setText("Score: "+goalsScored+" - "+pointsScored);
//            Toast.makeText(this, "No Score Data", Toast.LENGTH_SHORT).show();
        }
    }


    /* *
     * Stores data entered into array lists
     */
    public void storeDataInArrays() {
        Cursor cursor = myDB.readAllClickedSquadData(clickedSquadID);
        if (cursor.getCount() == 0) {
//            Toast.makeText(context, "No results", Toast.LENGTH_SHORT).show();
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                squadTableIDs.add(cursor.getString(0));
                squadIDs.add(cursor.getString(1));
                squadNames.add(cursor.getString(2));
                playerNames.add(cursor.getString(3));
                playerNos.add(cursor.getString(4));
            }
        }

    }
}