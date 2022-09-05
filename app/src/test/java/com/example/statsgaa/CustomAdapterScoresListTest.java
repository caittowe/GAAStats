package com.example.statsgaa;

import static org.junit.Assert.assertThat;

import android.app.Activity;
import android.content.Context;

import junit.framework.TestCase;

import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * UNIT TESTS
 */
public class CustomAdapterScoresListTest extends TestCase {

    // test data
    CustomAdapterScoresList cA;
    Activity activityValid;
    Context contextValid;
    ArrayList playerNamesOrderValid, playerNosOrderValid, playerGoalsValid, playerPointsValid, playerScoresOrderValid;
    int itemCountValid;

    @Test
    public void testDefaultConstructor() {
        cA = new CustomAdapterScoresList();
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

    playerPointsValid = new ArrayList();
    playerPointsValid.add(1);
    playerPointsValid.add(2);
    playerPointsValid.add(3);

    playerGoalsValid = new ArrayList();
    playerGoalsValid.add(1);
    playerGoalsValid.add(2);
    playerGoalsValid.add(3);

    playerScoresOrderValid = new ArrayList();
    playerScoresOrderValid.add(1);
    playerScoresOrderValid.add(2);
    playerScoresOrderValid.add(3);

    cA = new CustomAdapterScoresList(activityValid, contextValid, playerNamesOrderValid, playerNosOrderValid, playerGoalsValid, playerPointsValid, playerScoresOrderValid);
        activityValid = cA.activity;
        contextValid = cA.context;
    assertEquals(activityValid, cA.activity);
    assertEquals(contextValid, cA.context);
    assertEquals(playerNamesOrderValid, cA.playerNamesOrder);
    assertEquals(playerNosOrderValid, cA.playerNosOrder);
    assertEquals(playerGoalsValid, cA.playerGoals);
    assertEquals(playerPointsValid, playerScoresOrderValid);

    }

    @Test
    public void testGetItemCount() {
        playerNamesOrderValid = new ArrayList();
        playerNamesOrderValid.add("a");
        playerNamesOrderValid.add("b");
        playerNamesOrderValid.add("c");
        cA = new CustomAdapterScoresList(activityValid, contextValid, playerNamesOrderValid, playerNosOrderValid, playerGoalsValid, playerPointsValid, playerScoresOrderValid);
        itemCountValid = 3;
        assertEquals(itemCountValid, cA.getItemCount());
    }
}