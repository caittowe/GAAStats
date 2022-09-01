package com.example.statsgaa;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPlayer extends AppCompatActivity {

    private EditText nameInput;
    String squadID, playerName, playerNo;
    private Button updateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        nameInput = findViewById(R.id.nameInput);
        updateButton = findViewById(R.id.updatePlayerNameButton);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(playerNo +". "+ playerName);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.updatePlayerName(playerName, playerNo,squadID);
                playerName = nameInput.getText().toString().trim();
                myDB.updatePlayerName(playerName, playerNo,squadID);
            }
        });

    }

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("squadID") && getIntent().hasExtra("playerName") && getIntent().hasExtra("playerNo")){
            // getting data from intent
            squadID = getIntent().getStringExtra("squadID");
            playerName = getIntent().getStringExtra("playerName");
            playerNo = getIntent().getStringExtra("playerNo");
            // setting intent data
            nameInput.setText(playerName);
        } else {
//            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}