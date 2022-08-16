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

    MyDatabaseHelper myDB;
    String gameID, clickedSquadID;
    ArrayList<String> squad_table_id;
    ArrayList<String> squad_id;
    ArrayList<String> squad_name;
    ArrayList<String> player_name;
    ArrayList<String> player_no;

    String pointsScored, goalsScored;

    private static final long START_TIME_IN_MILLIS = 1800000;

    private TextView mTextViewCountDown;
    public TextView showScore;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftInMillis;
    private long mEndTime;

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

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
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
                                mCountDownTimer.cancel();
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
        squad_table_id = new ArrayList<>();
        squad_id = new ArrayList<>();
        squad_name = new ArrayList<>();
        player_name = new ArrayList<>();
        player_no = new ArrayList<>();

        getIntentData();
        storeDataInArrays();

        btnPlayer1 = findViewById(R.id.btnPlayer1);
        btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(0)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(0)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(0)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(0)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(1)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(1)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(1)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(1)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(1)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(2)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(2)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(2)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(2)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(2)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(3)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(3)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(3)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(3)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(3)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(4)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(4)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(4)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(4)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(4)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(5)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(5)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(5)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(5)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(5)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(6)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(6)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(6)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(6)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(6)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(7)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(7)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(7)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(7)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(7)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(8)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(8)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(8)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(8)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(8)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(9)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(9)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(9)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(9)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(9)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(10)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(10)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(10)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(10)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(10)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(11)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(11)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(11)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(11)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(11)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(12)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(12)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(12)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(12)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(12)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(13)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(13)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(13)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(13)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(13)));
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
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("timestamp", mTextViewCountDown.getText().toString());
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(14)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(14)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(14)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(14)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(14)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                intent.putExtra("points", pointsScored);
                intent.putExtra("goals", goalsScored);
                startActivity(intent);

            }
        });

    }

    public void updateScore(){
        showScore.setText("Score: "+goalsScored+" - "+pointsScored);
    }


    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateButtons();
            }
        }.start();

        mTimerRunning = true;
        updateButtons();
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        updateButtons();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateButtons() {
        if (mTimerRunning) {
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText("Pause");
        } else {
            mButtonStartPause.setText("Start");

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < START_TIME_IN_MILLIS) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mTimeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
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
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
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
                squad_table_id.add(cursor.getString(0));
                squad_id.add(cursor.getString(1));
                squad_name.add(cursor.getString(2));
                player_name.add(cursor.getString(3));
                player_no.add(cursor.getString(4));
            }
        }

    }
}