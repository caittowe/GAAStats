package com.example.statsgaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplaySquad extends AppCompatActivity {

    // vars and views
    public RecyclerView recyclerView;
    public MyDatabaseHelper myDB;
    public ArrayList<String> squadID, playerNo, playerName;
    public CustomAdapterPlayerList customAdapter;
    private Button startGame;
    private String clickedSquadID;
    private int gameID;

    /**
     * default constructor
     */
    public DisplaySquad(){

    }

    /**
     * displays the details entered from the dialog
     * calls storedatainarrays method
     * calls the custom adapter to layout the recycler view of all players
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_squad);

        gameID = getGameID();

        recyclerView = findViewById(R.id.recyclerView);
        startGame = findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplaySquad.this, GameStart.class);
                intent.putExtra("clicked_squad_id",String.valueOf(clickedSquadID));
                intent.putExtra("gameID",String.valueOf(gameID));
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(DisplaySquad.this);
        squadID = new ArrayList<>();
        playerName = new ArrayList<>();
        playerNo = new ArrayList<>();

        getIntentData();
        storeDataInArrays();

        customAdapter = new CustomAdapterPlayerList(DisplaySquad.this, this, clickedSquadID, playerNo, playerName);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplaySquad.this));
    }

    /**
     * allows results to be seen when data is changed
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    /**
     *  gets squad id of the squad that was clicked
     */
    public void getIntentData(){
            if (getIntent().hasExtra("squad_id")){
                // getting data from intent
                clickedSquadID = getIntent().getStringExtra("squad_id");
                Log.i("GOTSQUAD", "getIntentData: squad id =  "+clickedSquadID);
            } else {
            }
        }


    /**
     * Stores data entered into array lists
     */
    public void storeDataInArrays() {
        Cursor cursor = myDB.readPlayerNamePlayerNo(clickedSquadID);
        if (cursor.getCount() == 0) {
//           empty_imageview.setVisibility(View.VISIBLE);
//           no_data.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()) {
                playerNo.add(cursor.getString(0));
                playerName.add(cursor.getString(1));
            }
        }

    }

    /**
     * inflates the menu oin top corner of screen +++not yet implemented++
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /**
     * prompts the dialog when asked to delete all players
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * dialog that appears
     */
    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete all?");
        builder.setMessage("Are you sure you want to delete all data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(DisplaySquad.this);
                myDB.deleteSquad();
                //refreshes activity
                Intent intent = new Intent(DisplaySquad.this, SavedSquads.class);
                startActivity(intent);
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

    /**
     * returns ID of game
     * @return
     */
    public int getGameID() {
        MyDatabaseHelper myDB = new MyDatabaseHelper(DisplaySquad.this);
        gameID = myDB.getMaxGameID();
        return gameID;
    }

}
