package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {

    @Test
    public void testEditDistance() {
        String word1 = "horse";
        String word2 = "ros";
        assertEquals(3, EditDistance.minDistance(word1, word2));

        word1 = "intention";
        word2 = "execution";
        assertEquals(5, EditDistance.minDistance(word1, word2));
    }
}
