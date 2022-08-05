package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * adds each player to the database and sets their default values
 * should be up to 30 players when fully developed
 */
public class AddNewSquad extends AppCompatActivity {

    private EditText player1, player2, player3, player4, player5, player6, player7, player8, player9,
    player10, player11, player12,player13, player14, player15;

    private Button addPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad_setup);

        player1 = findViewById(R.id.player1input);
        player2 = findViewById(R.id.player2input);
        player3 = findViewById(R.id.player3input);
        player4 = findViewById(R.id.player4input);
        player5 = findViewById(R.id.player5input);
        player6 = findViewById(R.id.player6input);
        player7 = findViewById(R.id.player7input);
        player8 = findViewById(R.id.player8input);
        player9 = findViewById(R.id.player9input);
        player10 = findViewById(R.id.player10input);
        player11 = findViewById(R.id.player11input);
        player12 = findViewById(R.id.player12input);
        player13 = findViewById(R.id.player13input);
        player14 = findViewById(R.id.player14input);
        player15 = findViewById(R.id.player15input);

        addPlayerButton = findViewById(R.id.addPlayersButton);
        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddNewSquad.this);
                myDB.addPlayer(player1.getText().toString().trim(),String.valueOf(1),String.valueOf(0));
                myDB.addPlayer(player2.getText().toString().trim(),String.valueOf(2),String.valueOf(0));
                myDB.addPlayer(player3.getText().toString().trim(),String.valueOf(3),String.valueOf(0));
                myDB.addPlayer(player4.getText().toString().trim(),String.valueOf(4),String.valueOf(0));
                myDB.addPlayer(player5.getText().toString().trim(),String.valueOf(5),String.valueOf(0));
                myDB.addPlayer(player6.getText().toString().trim(),String.valueOf(6),String.valueOf(0));
                myDB.addPlayer(player7.getText().toString().trim(),String.valueOf(7),String.valueOf(0));
                myDB.addPlayer(player8.getText().toString().trim(),String.valueOf(8),String.valueOf(0));
                myDB.addPlayer(player9.getText().toString().trim(),String.valueOf(9),String.valueOf(0));
                myDB.addPlayer(player10.getText().toString().trim(),String.valueOf(10),String.valueOf(0));
                myDB.addPlayer(player11.getText().toString().trim(),String.valueOf(11),String.valueOf(0));
                myDB.addPlayer(player12.getText().toString().trim(),String.valueOf(12),String.valueOf(0));
                myDB.addPlayer(player13.getText().toString().trim(),String.valueOf(13),String.valueOf(0));
                myDB.addPlayer(player14.getText().toString().trim(),String.valueOf(14),String.valueOf(0));
                myDB.addPlayer(player15.getText().toString().trim(),String.valueOf(15),String.valueOf(0));

                Intent intent = new Intent(AddNewSquad.this, SavedSquads.class);
                startActivity(intent);

            }
        });

    }
}