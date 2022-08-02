package com.example.statsgaa;

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

import java.io.Serializable;
import java.util.ArrayList;

public class EnterStat extends AppCompatActivity {

    private EditText title_input, author_input, pages_input;
    private Button updateButton, deleteButton, addPages;

    String author, id, title, pages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_stat);

        title_input = findViewById(R.id.titleInput2);
        author_input = findViewById(R.id.authorInput2);
        pages_input = findViewById(R.id.pagesInput2);
        updateButton = findViewById(R.id.updateBookButton);
        deleteButton = findViewById(R.id.deleteBookButton);
        addPages = findViewById(R.id.addPages);

        // first we call this
        getAndSetIntentData();

        // set actionbar after get and set method
        ActionBar ab = getSupportActionBar();
        ab.setTitle(title);
        if (ab != null) {
            ab.setTitle(title);
        }

        // increments number of pages by 1
        addPages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                int increment = 1;
                int nopages = Integer.valueOf(pages);
                int newpages = nopages+increment;
                myDB.updateData(id, title, author, String.valueOf(newpages));
                Intent intent = new Intent(EnterStat.this, SavedSquads.class);
                startActivity(intent);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // and only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                myDB.updateData(id, title, author, pages);
                title = title_input.getText().toString().trim();
                author = author_input.getText().toString().trim();
                pages = pages_input.getText().toString().trim();
                myDB.updateData(id, title, author, pages);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
                myDB.deleteOneRow(id);
                confirmDialog();
            }
        });
    }

    /**
     *
     */
    public void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("pages")) {
            // getting data from intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            // setting intent data
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EnterStat.this);
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