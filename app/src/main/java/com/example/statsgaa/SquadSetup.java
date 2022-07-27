package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class SquadSetup extends AppCompatActivity {

    Button goButton;
    EditText enterPlayer1,enterPlayer2,enterPlayer3,enterPlayer4,enterPlayer5,enterPlayer6;
    public ArrayList<Player> players = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad_setup);

        enterPlayer1 = findViewById(R.id.enterPlayerNo1);
        enterPlayer2 = findViewById(R.id.enterPlayerNo2);
        enterPlayer3 = findViewById(R.id.enterPlayerNo3);
        enterPlayer4 = findViewById(R.id.enterPlayerNo4);
        enterPlayer5 = findViewById(R.id.enterPlayerNo5);
        enterPlayer6 = findViewById(R.id.enterPlayerNo6);

        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(SquadSetup.this);
                myDB.addPlayer(enterPlayer1.getText().toString().trim());
                myDB.addPlayer(enterPlayer2.getText().toString().trim());
                myDB.addPlayer(enterPlayer3.getText().toString().trim());
                myDB.addPlayer(enterPlayer4.getText().toString().trim());
                myDB.addPlayer(enterPlayer5.getText().toString().trim());
                myDB.addPlayer(enterPlayer6.getText().toString().trim());
                Intent intent = new Intent(SquadSetup.this, StatActivity.class);
                Player player1 = new Player(enterPlayer1.getText().toString().trim(),1,0);
                Player player2 = new Player(enterPlayer2.getText().toString().trim(),2,0);
                Player player3 = new Player(enterPlayer3.getText().toString().trim(),3,0);
                Player player4 = new Player(enterPlayer4.getText().toString().trim(),4,0);
                Player player5 = new Player(enterPlayer5.getText().toString().trim(),5,0);
                Player player6 = new Player(enterPlayer6.getText().toString().trim(),6,0);
                players.add(player1);
                players.add(player2);
                players.add(player3);
                players.add(player4);
                players.add(player5);
                players.add(player6);

               // pass array list to
            }
        });


    }
}