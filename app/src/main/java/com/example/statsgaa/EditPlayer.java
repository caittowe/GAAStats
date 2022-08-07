package com.example.statsgaa;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPlayer extends AppCompatActivity {

    private EditText name_input, no_input;
    String squad_table_id, squad_id, squad_name, player_name, player_no;
    private Button updateButton, deleteButton;


    String number, id, name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        name_input = findViewById(R.id.nameInput);
        updateButton = findViewById(R.id.updatePlayerNameButton);
        deleteButton = findViewById(R.id.deletePlayerButton);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(player_no+". "+player_name);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // and only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.updatePlayerName(player_name, player_no);
                player_name = name_input.getText().toString().trim();
//                number = number_input.getText().toString().trim();
                myDB.updatePlayerName(player_name, player_no);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.deleteOnePlayer(player_no);
                confirmDialog();
            }
        });
    }

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("squad_table_id") && getIntent().hasExtra("squad_id") && getIntent().hasExtra("squad_name") && getIntent().hasExtra("player_name")
                && getIntent().hasExtra("player_no")){
            // getting data from intent
            squad_table_id = getIntent().getStringExtra("squad_table_id");
            squad_id = getIntent().getStringExtra("squad_id");
            squad_name = getIntent().getStringExtra("squad_name");
            player_name = getIntent().getStringExtra("player_name");
            player_no = getIntent().getStringExtra("player_no");
            // setting intent data
            name_input.setText(player_name);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + player_name + " ?");
        builder.setMessage("Are you sure you want to delete " + player_name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.deleteOnePlayer(player_no);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}