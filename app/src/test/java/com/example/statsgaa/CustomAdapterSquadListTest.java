package com.example.statsgaa;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Context;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class CustomAdapterSquadListTest extends TestCase {

    // test data
    CustomAdapterSquadList cA;
    Activity activityValid;
    Context contextValid;
    ArrayList squadIDValid, squadNameValid;
    int itemCountValid;

    @Test
    public void testDefaultConstructor() {
        cA = new CustomAdapterSquadList();
        assertNotNull(cA);
    }

    @Test
    public void testConstructorWithArgsValid() {
        squadNameValid = new ArrayList();
        squadNameValid.add("a");
        squadNameValid.add("b");
        squadNameValid.add("c");

        squadIDValid = new ArrayList();
        squadIDValid.add(1);
        squadIDValid.add(2);
        squadIDValid.add(3);

        cA = new CustomAdapterSquadList(activityValid, contextValid, squadIDValid, squadNameValid);
        activityValid = cA.activity;
        contextValid = cA.context;
        assertEquals(activityValid, cA.activity);
        assertEquals(contextValid, cA.context);
        assertEquals(squadIDValid, cA.squadID);
        assertEquals(squadNameValid, cA.squadName);
    }

    @Test
    public void testGetItemCount() {
        squadIDValid = new ArrayList();
        squadIDValid.add(1);
        squadIDValid.add(2);
        squadIDValid.add(3);
        cA = new CustomAdapterSquadList(activityValid, contextValid, squadIDValid, squadNameValid);
        itemCountValid = 3;
        assertEquals(itemCountValid, cA.getItemCount());
    }
}