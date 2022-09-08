package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class ShowPossessionsTest {

    ShowPossessions showPossessions;

    @Test
    public void getIntentDataTest() {
        showPossessions = mock(ShowPossessions.class);
        showPossessions.getIntentData();
        verify(showPossessions).getIntentData();
    }

    @Test
    public void storeDataInArraysTest() {
        showPossessions = mock(ShowPossessions.class);
        showPossessions.storeDataInArrays();
        verify(showPossessions).storeDataInArrays();
    }

    @Test
    public void addSetPossessionsTest() {
        showPossessions = mock(ShowPossessions.class);
        showPossessions.addSetPossessions();
        verify(showPossessions).addSetPossessions();
    }

    @Test
    public void returnPossessionsDescTest() {
        showPossessions = mock(ShowPossessions.class);
        showPossessions.returnPossessionsDesc();
        verify(showPossessions).returnPossessionsDesc();
    }
}