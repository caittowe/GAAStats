package com.example.newgotconfused;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SquadSetup extends AppCompatActivity implements View.OnClickListener {

    Button goButton;
    EditText enterPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad_setup);

        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(this);

        enterPlayer1 = findViewById(R.id.enterPlayer1);
        enterPlayer1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.goButton):
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }


}