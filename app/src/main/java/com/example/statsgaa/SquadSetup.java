package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SquadSetup extends AppCompatActivity {

    Button goButton;
    EditText enterPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad_setup);

        enterPlayer1 = findViewById(R.id.enterPlayerNo1);

        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(SquadSetup.this);
                myDB.addPlayer(enterPlayer1.getText().toString().trim());
                Intent intent = new Intent(SquadSetup.this, StatActivity.class);
                startActivity(intent);
            }
        });


    }
}