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
public class SquadSetup extends AppCompatActivity {

    private EditText player1, player2, player3, player4, player5, player6;
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

        addPlayerButton = findViewById(R.id.addPlayersButton);
        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(SquadSetup.this);
                myDB.addBook(player1.getText().toString().trim(),String.valueOf(1),String.valueOf(0));
                myDB.addBook(player2.getText().toString().trim(),String.valueOf(2),String.valueOf(0));
                myDB.addBook(player3.getText().toString().trim(),String.valueOf(3),String.valueOf(0));
                myDB.addBook(player4.getText().toString().trim(),String.valueOf(4),String.valueOf(0));
                myDB.addBook(player5.getText().toString().trim(),String.valueOf(5),String.valueOf(0));
                myDB.addBook(player6.getText().toString().trim(),String.valueOf(6),String.valueOf(0));
                Intent intent = new Intent(SquadSetup.this, SavedSquads.class);
                startActivity(intent);

            }
        });

    }
}