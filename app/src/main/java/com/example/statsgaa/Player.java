package com.example.statsgaa;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Class represents a player as an object
 */
public class Player implements Serializable {

    // instance vars
    private String playerName;
    private int playerNumber;
    private int playerScores;

    //constructors

    /**
     * default
     */
    public Player() {

    }

    /**
     * with args
     *
     * @param playerName
     * @param playerNumber
     * @param playerScores
     */
    public Player(String playerName, int playerNumber, int playerScores) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.playerScores = playerScores;
    }

    // methods
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {


        this.playerName = playerName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(int playerScores) {
        this.playerScores = playerScores;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerNumber=" + playerNumber +
                ", playerScores=" + playerScores +
                '}';
    }
}