package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class EditPlayerTest {

    EditPlayer editPlayer;

    @Test
    public void getAndSetIntentData() {
        editPlayer = mock(EditPlayer.class);
        editPlayer.getAndSetIntentData();
        verify(editPlayer).getAndSetIntentData();
    }
}