package com.example.statsgaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class SquadSetup extends AppCompatActivity {

    private EditText titleInput, authorInput, pagesInput;
    private Button addBookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad_setup);

        titleInput = findViewById(R.id.titleInput);
        authorInput = findViewById(R.id.authorInput);
        pagesInput = findViewById(R.id.pagesInput);

        addBookButton = findViewById(R.id.addBookButton);
        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(SquadSetup.this);
                myDB.addBook(titleInput.getText().toString().trim(), authorInput.getText().toString().trim(),
                        Integer.valueOf(pagesInput.getText().toString().trim()));
            }
        });

    }
}