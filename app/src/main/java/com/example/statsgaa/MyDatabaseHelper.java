package com.example.statsgaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Stats.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PLAYER = "player";
    private static final String TABLE_STAT = "stat";
    private static final String TABLE_PLAYER_STAT = "player_stat";
    private static final String PLAYER_PK = "player_id";
    private static final String STAT_PK = "stat_id";
    private static final String PLAYER_STAT_PK = "player_stat_id";
    private static final String PLAYER_COLUMN = "player_name";
    private static final String STAT_COLUMN = "stat_name";
    private static final String PLAYER_STAT_COLUMN = "stat_count";

    private static final String CREATE_TABLE_PLAYER = "CREATE TABLE "
            + TABLE_PLAYER + "(" + PLAYER_PK
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + PLAYER_COLUMN + " TEXT );";

    private static final String CREATE_TABLE_STAT = "CREATE TABLE "
            + TABLE_STAT + "(" + STAT_PK
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + STAT_COLUMN + " TEXT );";

    private static final String CREATE_TABLE__PLAYER_STAT = "CREATE TABLE "
            + TABLE_PLAYER_STAT + "(" + PLAYER_STAT_PK
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + PLAYER_STAT_COLUMN + " TEXT );";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    /**
     * Creates new tables in the database
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLAYER);
        db.execSQL(CREATE_TABLE_STAT);
        db.execSQL(CREATE_TABLE__PLAYER_STAT);

    }

    /**
     * Drops tables in database
     *
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_STAT);
        onCreate(db);
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_PLAYER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    /**
     * adds a new player to the database
     */
    public void addPlayer(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(PLAYER_COLUMN, name);

        long result = db.insert(TABLE_PLAYER, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add Player", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * adds stats to database
     */
    public void addStat() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String name = "Score";
        cv.put(STAT_COLUMN, name);

        long result = db.insert(TABLE_PLAYER, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add stat", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Stat Added", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * deletes one row in the table
     * @param row_id
     */
    public void deleteOneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_PLAYER, "player_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "Deleted Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * deletes all data from table
     */
    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_PLAYER);
    }
}
