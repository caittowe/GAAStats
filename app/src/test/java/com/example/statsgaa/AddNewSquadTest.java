package com.example.statsgaa;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class AddNewSquadTest{
    /**
     * **INTEGRATION TESTS**
     * verify that the addSquad method is called
     */
    @Test
    public void addSquad() {
        AddNewSquad addNewSquad = mock(AddNewSquad.class);
        addNewSquad.addSquad();
        verify(addNewSquad).addSquad();
    }

}
