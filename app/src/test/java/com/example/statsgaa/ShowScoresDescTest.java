package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class ShowScoresDescTest {

    ShowScoresDesc showScoresDesc;

    @Test
    public void getIntentData() {
        showScoresDesc = mock(ShowScoresDesc.class);
        showScoresDesc.getIntentData();
        verify(showScoresDesc).getIntentData();
    }

    @Test
    public void storeDataInArrays() {
        showScoresDesc = mock(ShowScoresDesc.class);
        showScoresDesc.storeDataInArrays();
        verify(showScoresDesc).storeDataInArrays();
    }

    @Test
    public void addSetScores() {
        showScoresDesc = mock(ShowScoresDesc.class);
        showScoresDesc.addSetScores();
        verify(showScoresDesc).addSetScores();
    }

    @Test
    public void returnScorersDesc() {
        showScoresDesc = mock(ShowScoresDesc.class);
        showScoresDesc.returnScorersDesc();
        verify(showScoresDesc).returnScorersDesc();
    }
}