package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest2 {
    @Test
    public void testMinDistance() {
        EditDistance2 solution = new EditDistance2();

        assertEquals(3, solution.minDistance("horse", "ros"));
        assertEquals(5, solution.minDistance("intention", "execution"));
        assertEquals(0, solution.minDistance("", ""));
        assertEquals(4, solution.minDistance("abc", ""));
        assertEquals(2, solution.minDistance("ab", "acb"));
    }

    @Test
    public void testEmptyWord1() {
        EditDistance2 solution = new EditDistance2();

        assertEquals(3, solution.minDistance("", "abc"));
        assertEquals(1, solution.minDistance("", "a"));
    }

    @Test
    public void testEmptyWord2() {
        EditDistance2 solution = new EditDistance2();

        assertEquals(3, solution.minDistance("abc", ""));
        assertEquals(1, solution.minDistance("a", ""));
    }

    @Test
    public void testSameWords() {
        EditDistance2 solution = new EditDistance2();

        assertEquals(0, solution.minDistance("abc", "abc"));
        assertEquals(0, solution.minDistance("a", "a"));
    }

    @Test
    public void testSingleCharacterDifference() {
        EditDistance2 solution = new EditDistance2();

        assertEquals(1, solution.minDistance("a", "b"));
        assertEquals(1, solution.minDistance("abc", "abx"));
    }
}
