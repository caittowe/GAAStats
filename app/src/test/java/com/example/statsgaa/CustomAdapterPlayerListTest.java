package com.example.statsgaa;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Context;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomAdapterPlayerListTest extends TestCase {

    // test data
    CustomAdapterPlayerList cA;
    Activity activityValid;
    Context contextValid;
    String squadID;
    ArrayList playerNameValid, playerNoValid;
    int itemCountValid;

    @Test
    public void testDefaultConstructor() {
        cA = new CustomAdapterPlayerList();
        assertNotNull(cA);
    }

    @Test
    public void testConstructorWithArgsValid() {
        playerNameValid = new ArrayList();
        playerNameValid.add("a");
        playerNameValid.add("b");
        playerNameValid.add("c");

        playerNoValid = new ArrayList();
        playerNoValid.add(1);
        playerNoValid.add(2);
        playerNoValid.add(3);

        cA = new CustomAdapterPlayerList(activityValid, contextValid, squadID, playerNoValid, playerNameValid);
        activityValid = cA.activity;
        contextValid = cA.context;
        assertEquals(activityValid, cA.activity);
        assertEquals(contextValid, cA.context);
        assertEquals(playerNameValid, cA.playerName);
        assertEquals(playerNoValid, cA.playerNo);
        assertEquals(squadID, cA.squadID);
    }

    @Test
    public void testGetItemCount() {
        playerNameValid = new ArrayList();
        playerNameValid.add("a");
        playerNameValid.add("b");
        playerNameValid.add("c");
        cA = new CustomAdapterPlayerList(activityValid, contextValid, squadID, playerNameValid, playerNoValid);
        itemCountValid = 3;
        assertEquals(itemCountValid, cA.getItemCount());
    }
}
