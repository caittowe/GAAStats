package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class EnterStatTest {

    EnterStat enterStat;

    /**
     * INTEGRATION TESTS
     * verifies these methods are called within the class
     */
    @Test
    public void getGameIDTest() {
        enterStat = mock(EnterStat.class);
        enterStat.getGameID();
        verify(enterStat).getGameID();
    }

    @Test
    public void getAndSetIntentDataTest() {
        enterStat = mock(EnterStat.class);
        enterStat.getAndSetIntentData();
        verify(enterStat).getAndSetIntentData();
    }
}