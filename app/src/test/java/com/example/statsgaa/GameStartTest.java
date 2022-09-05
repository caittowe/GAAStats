package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class GameStartTest {

    GameStart gameStart;

    @Test
    public void getIntentData() {
        gameStart = mock(GameStart.class);
        gameStart.getIntentData();
        verify(gameStart).getIntentData();
    }

    @Test
    public void storeDataInArrays() {
        gameStart = mock(GameStart.class);
        gameStart.storeDataInArrays();
        verify(gameStart).storeDataInArrays();
    }
}