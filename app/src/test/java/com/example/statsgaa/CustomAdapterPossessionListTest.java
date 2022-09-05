package com.example.statsgaa;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Context;

import junit.framework.TestCase;

import org.junit.Before;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomAdapterPossessionListTest extends TestCase {

    // test data
    CustomAdapterPossessionList cA;
    Activity activityValid;
    Context contextValid;
    ArrayList playerNamesOrderValid, playerNosOrderValid, playerPossessionsOrderValid;
    int itemCountValid;

    @Test
    public void testDefaultConstructor() {
        cA = new CustomAdapterPossessionList();
        assertNotNull(cA);
    }

    @Test
    public void testConstructorWithArgsValid() {
        playerNamesOrderValid = new ArrayList();
        playerNamesOrderValid.add("a");
        playerNamesOrderValid.add("b");
        playerNamesOrderValid.add("c");

        playerNosOrderValid = new ArrayList();
        playerNosOrderValid.add(1);
        playerNosOrderValid.add(2);
        playerNosOrderValid.add(3);

        playerPossessionsOrderValid = new ArrayList();
        playerPossessionsOrderValid.add(1);
        playerPossessionsOrderValid.add(2);
        playerPossessionsOrderValid.add(3);

        cA = new CustomAdapterPossessionList(activityValid, contextValid, playerNamesOrderValid, playerNosOrderValid,playerPossessionsOrderValid);
        activityValid = cA.activity;
        contextValid = cA.context;
        assertEquals(activityValid, cA.activity);
        assertEquals(contextValid, cA.context);
        assertEquals(playerNamesOrderValid, cA.playerNamesOrder);
        assertEquals(playerNosOrderValid, cA.playerNosOrder);
        assertEquals(playerPossessionsOrderValid, cA.playerPossessionsOrder);
    }

    @Test
    public void testGetItemCount() {
        playerNamesOrderValid = new ArrayList();
        playerNamesOrderValid.add("a");
        playerNamesOrderValid.add("b");
        playerNamesOrderValid.add("c");
        cA = new CustomAdapterPossessionList(activityValid, contextValid, playerNamesOrderValid, playerNosOrderValid,playerPossessionsOrderValid);
        itemCountValid = 3;
        assertEquals(itemCountValid, cA.getItemCount());
    }
}
