package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class SavedSquadsTest {

    SavedSquads savedSquads;

    @Test
    public void storeDataInArraysTest() {
        savedSquads = mock(SavedSquads.class);
        savedSquads.storeDataInArrays();
        verify(savedSquads).storeDataInArrays();
    }

    @Test
    public void confirmDialogTest() {
        savedSquads = mock(SavedSquads.class);
        savedSquads.confirmDialog();
        verify(savedSquads).confirmDialog();
    }
}