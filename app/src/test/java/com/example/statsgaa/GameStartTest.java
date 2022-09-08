package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GameStartTest {

    GameStart gameStart;

    @Test
    public void getIntentDataTest() {
        gameStart = mock(GameStart.class);
        gameStart.getIntentData();
        verify(gameStart).getIntentData();
    }

    @Test
    public void storeDataInArraysTest() {
        gameStart = mock(GameStart.class);
        gameStart.storeDataInArrays();
        verify(gameStart).storeDataInArrays();
    }

    @Test
    public void onStartTest() {
        gameStart = mock(GameStart.class);
        gameStart.onStart();
        verify(gameStart).onStart();
    }

    @Test
    public void onStopTest() {
        gameStart = mock(GameStart.class);
        gameStart.onStop();
        verify(gameStart).onStop();
    }

    @Test
    public void updateButtonsTest() {
        gameStart = mock(GameStart.class);
        gameStart.updateButtons();
        verify(gameStart).updateButtons();
    }

    @Test
    public void updateCountDownText() {
        gameStart = mock(GameStart.class);
        gameStart.updateCountDownText();
        verify(gameStart).updateCountDownText();
    }

    @Test
    public void resetTimerTest() {
        gameStart = mock(GameStart.class);
        gameStart.resetTimer();
        verify(gameStart).resetTimer();
    }

    @Test
    public void pauseTimerTest() {
        gameStart = mock(GameStart.class);
        gameStart.resetTimer();
        verify(gameStart).resetTimer();
    }
}