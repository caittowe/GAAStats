package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

import org.junit.Test;

public class DisplaySquadTest {

    DisplaySquad displaySquad;

    /**
     * INTEGRATION TESTS
     * verifies these methods are called within the class
     */
    @Test
    public void getGameIDTest() {
        displaySquad = mock(DisplaySquad.class);
        displaySquad.getGameID();
        verify(displaySquad).getGameID();
    }

    @Test
    public void getIntentDataTest() {
        displaySquad = mock(DisplaySquad.class);
        displaySquad.getIntentData();
        verify(displaySquad).getIntentData();
    }

    @Test
    public void storeDataInArraysTest() {
        displaySquad = mock(DisplaySquad.class);
        displaySquad.storeDataInArrays();
        verify(displaySquad).storeDataInArrays();
    }

    @Test
    public void confirmDialogTest() {
        displaySquad = mock(DisplaySquad.class);
        displaySquad.confirmDialog();
        verify(displaySquad).confirmDialog();
    }
}