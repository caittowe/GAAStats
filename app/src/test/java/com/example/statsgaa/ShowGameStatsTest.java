package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class ShowGameStatsTest {

    ShowGameStats showGameStats;

    @Test
    public void getIntentDataTest(){
        showGameStats = mock(ShowGameStats.class);
        showGameStats.getIntentData();
        verify(showGameStats).getIntentData();
    }

    @Test
    public void storeDataInArraysTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeDataInArrays();
        verify(showGameStats).storeDataInArrays();
    }

    @Test
    public void storeSetShotsDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetShotsData();
        verify(showGameStats).storeSetShotsData();
    }

    @Test
    public void storeSetScoreDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetScoreData();
        verify(showGameStats).storeSetScoreData();
    }

    @Test
    public void storeSetWideDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetWideData();
        verify(showGameStats).storeSetWideData();
    }

    @Test
    public void storeSetPosTurnoverDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetPosTurnoverData();
        verify(showGameStats).storeSetPosTurnoverData();
    }

    @Test
    public void storeSetNegTurnoverDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetNegTurnoverData();
        verify(showGameStats).storeSetNegTurnoverData();
    }

    @Test
    public void storeSetFoulWonDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetFoulWonData();
        verify(showGameStats).storeSetFoulWonData();
    }

    @Test
    public void storeSetFoulConcDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetFoulConcData();
        verify(showGameStats).storeSetFoulConcData();
    }

    @Test
    public void storeSetOwnKickoutWonDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetOwnKickoutWonData();
        verify(showGameStats).storeSetOwnKickoutWonData();
    }

    @Test
    public void storeSetOppKickoutWonDataTest() {
        showGameStats = mock(ShowGameStats.class);
        showGameStats.storeSetOppKickoutWonData();
        verify(showGameStats).storeSetOppKickoutWonData();
    }
}