package com.example.statsgaa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GameStart extends AppCompatActivity {

    MyDatabaseHelper myDB;
    Context context;
    String id, name, number, scores, clickedSquadID;
    ArrayList<String> squad_table_id;
    ArrayList<String> squad_id;
    ArrayList<String> squad_name;
    ArrayList<String> player_name;
    ArrayList<String> player_no;

    int seconds;
    int minutes;

    TextView gameTimer;
    Timer timer;
    Double time = 0.00;
    TimerTask timerTask;
    Boolean isPlaying = false;
    Button timerStopStart, endTheGame, btnPlayer1, btnPlayer2, btnPlayer3, btnPlayer4, btnPlayer5, btnPlayer6, btnPlayer7, btnPlayer8, btnPlayer9, btnPlayer10, btnPlayer11, btnPlayer12, btnPlayer13, btnPlayer14, btnPlayer15;

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

        gameTimer = findViewById(R.id.gameTimer);

        timer = new Timer();

        timerStopStart = findViewById(R.id.timerStopStart);
        timerStopStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying == false) {
                    setButtonUI("PAUSE", R.color.red);
                    isPlaying = true;
                    startTimer();
                } else {
                    isPlaying = false;
                    setButtonUI("START", R.color.green);
                    timerTask.cancel();
                }
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
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(0)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(0)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(0)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(0)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(0)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);
            }
        });

        btnPlayer2 = findViewById(R.id.btnPlayer2);
        btnPlayer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(1)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(1)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(1)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(1)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(1)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer3 = findViewById(R.id.btnPlayer3);
        btnPlayer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(2)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(2)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(2)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(2)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(2)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer4 = findViewById(R.id.btnPlayer4);
        btnPlayer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(3)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(3)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(3)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(3)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(3)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer5 = findViewById(R.id.btnPlayer5);
        btnPlayer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(4)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(4)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(4)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(4)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(4)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer6 = findViewById(R.id.btnPlayer6);
        btnPlayer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(5)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(5)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(5)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(5)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(5)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer7 = findViewById(R.id.btnPlayer7);
        btnPlayer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(6)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(6)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(6)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(6)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(6)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer8 = findViewById(R.id.btnPlayer8);
        btnPlayer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(7)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(7)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(7)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(7)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(7)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer9 = findViewById(R.id.btnPlayer9);
        btnPlayer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(8)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(8)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(8)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(8)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(8)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer10 = findViewById(R.id.btnPlayer10);
        btnPlayer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(9)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(9)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(9)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(9)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(9)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer11 = findViewById(R.id.btnPlayer11);
        btnPlayer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(10)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(10)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(10)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(10)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(10)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer12 = findViewById(R.id.btnPlayer12);
        btnPlayer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(11)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(11)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(11)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(11)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(11)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer13 = findViewById(R.id.btnPlayer13);
        btnPlayer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(12)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(12)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(12)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(12)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(12)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer14 = findViewById(R.id.btnPlayer14);
        btnPlayer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(13)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(13)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(13)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(13)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(13)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        btnPlayer15 = findViewById(R.id.btnPlayer15);
        btnPlayer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameStart.this, EnterStat.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(14)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(14)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(14)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(14)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(14)));
                intent.putExtra("clickedSquadID", toString().valueOf(clickedSquadID));
                startActivity(intent);

            }
        });

        endTheGame = findViewById(R.id.endTheGame);
        endTheGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder endGameAlert = new AlertDialog.Builder(GameStart.this);
                endGameAlert.setTitle("End Game");
                endGameAlert.setMessage("Are you sure you want to end the game?");
                endGameAlert.setPositiveButton("End Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (timerTask == null) {
                            timerTask.cancel();
                            time = 0.0;
                            isPlaying = false;
                            gameTimer.setText(formatTime(0,0));
                        }
                        Intent intent = new Intent(GameStart.this, ShowGameStats.class);
                        startActivity(intent);
                    }
                });
                endGameAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do nothing
                    }
                });
                endGameAlert.show();

            }
        });

    }

    /**
     * sets colour and text of button when clicked
     *
     * @param start
     */
    public void setButtonUI(String start, int colour) {
        timerStopStart.setText(start);
        timerStopStart.setBackgroundColor(ContextCompat.getColor(GameStart.this, colour));
    }

    /**
     * starts game timer
     */
    public void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        gameTimer.setText(getTimerText());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    /**
     * gets timer text
     *
     * @return
     */
    public String getTimerText() {
        int rounded = (int) Math.round(time);
        seconds = ((rounded % 86400) % 3600) % 60;
        minutes = ((rounded % 86400) % 3600) / 60;

        return formatTime(seconds, minutes);


    }

    /*
     * formats time
     */
    private String formatTime(int seconds, int minutes) {
        return String.format("%02d", minutes) + "." + String.format("%02d", seconds);

    }

    /**
     * gets squad id of the squad that was clicked ont
     */
    public void getIntentData() {
        if (getIntent().hasExtra("clicked_squad_id")) {
            // getting data from intent
            clickedSquadID = getIntent().getStringExtra("clicked_squad_id");
            storeDataInArrays();
            Log.i("GOTSQUAD", "getIntentData: squad id =  " + clickedSquadID);
        } else {
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