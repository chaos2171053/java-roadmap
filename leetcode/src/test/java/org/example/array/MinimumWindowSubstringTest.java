package org.example.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstringTest {

    @Test
    public void testMinimumWindowSubstring_Example1() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testMinimumWindowSubstring_Example2() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String s = "a";
        String t = "a";
        String expected = "a";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testMinimumWindowSubstring_Example3() {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String s = "a";
        String t = "aa";
        String expected = "";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }
}


