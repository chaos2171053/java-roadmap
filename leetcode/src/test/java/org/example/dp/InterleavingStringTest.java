package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InterleavingStringTest {

    @Test
    public void testBothStringsEmpty() {
        InterleavingString solution = new InterleavingString();
        assertTrue(solution.isInterleave("", "", ""));
    }

    @Test
    public void testOneStringEmpty() {
        InterleavingString solution = new InterleavingString();
        assertTrue(solution.isInterleave("a", "", "a"));
    }

    @Test
    public void testRegularInterleaving() {
        InterleavingString solution = new InterleavingString();
        assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void testComplexInterleaving() {
        InterleavingString solution = new InterleavingString();
        assertTrue(solution.isInterleave("abc", "def", "adbcef"));
    }
}

