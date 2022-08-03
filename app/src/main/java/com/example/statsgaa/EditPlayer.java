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

    private EditText name_input, number_input, scores_input;
    private Button updateButton, deleteButton;


    String number, id, name, scores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        name_input = findViewById(R.id.nameInput);
        number_input = findViewById(R.id.numberInput);
        scores_input = findViewById(R.id.scoresInput);
        updateButton = findViewById(R.id.updateBookButton);
        deleteButton = findViewById(R.id.deleteBookButton);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(name);
        if (ab != null) {
            ab.setTitle(name);
        }

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // and only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.updateData(id, name, number, scores);
                name = name_input.getText().toString().trim();
                number = number_input.getText().toString().trim();
                scores = scores_input.getText().toString().trim();
                myDB.updateData(id, name, number, scores);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.deleteOneRow(id);
                confirmDialog();
            }
        });
    }

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("scores")) {
            // getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");
            scores = getIntent().getStringExtra("scores");

            // setting intent data
            name_input.setText(name);
            number_input.setText(number);
            scores_input.setText(scores);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditPlayer.this);
                myDB.deleteOneRow(id);
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