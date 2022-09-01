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

    Button newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.buttonNewGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View myView = inflater.inflate(R.layout.new_game_dialog, null);
                builder.setView(myView);

                EditText enterMatchName, enterTeam1, enterTeam2, enterDate, enterTime, enterLocation;
                enterMatchName = myView.findViewById(R.id.etMatchName);
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
                                MyDatabaseHelper db = new MyDatabaseHelper(MainActivity.this);
                                db.createNewMatch(enterMatchName.getText().toString(), enterTeam1.getText().toString(), enterTeam2.getText().toString(),
                                        enterDate.getText().toString(), enterTime.getText().toString(), enterLocation.getText().toString());
                                Intent intent = new Intent(MainActivity.this, SavedSquads.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null);

                builder.create();
                builder.show();
            }
        });

    }
}
