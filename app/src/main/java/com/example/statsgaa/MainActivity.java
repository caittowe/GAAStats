package com.example.statsgaa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button newGame, prevGames, newSquad, savedSquads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.buttonNewGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater= getLayoutInflater();
                final View myView= inflater.inflate(R.layout.new_game_dialog, null);
                builder.setView(myView);

                EditText enterTeam1, enterTeam2, enterDate, enterTime, enterLocation;
                enterTeam1 = myView.findViewById(R.id.etTeam1);
                enterTeam2 = myView.findViewById(R.id.etTeam2);
                enterDate = myView.findViewById(R.id.etDate);
                enterTime = myView.findViewById(R.id.etTime);
                enterLocation = myView.findViewById(R.id.etLocation);

                builder.setTitle("New Game")
                        .setCancelable(true)
                        .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainActivity.this, SavedSquads.class);
                                intent.putExtra("TEAM1", enterTeam1.getText().toString());
                                intent.putExtra("TEAM2", enterTeam2.getText().toString());
                                intent.putExtra("DATE", toString().valueOf(enterDate.getText()));
                                intent.putExtra("TIME", toString().valueOf(enterTime.getText()));
                                intent.putExtra("LOCATION", enterLocation.getText().toString());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null);

                builder.create();
                builder.show();
            }
        });

        prevGames = findViewById(R.id.buttonPrevGames);
        prevGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PreviousGames.class);
                startActivity(intent);
            }
        });
    }
}
