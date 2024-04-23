package org.example.slidewindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinWindowSubstringTest {

    private final MinWindowSubstring solution = new MinWindowSubstring();

    @Test
    public void testMinWindowSubstring1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testMinWindowSubstring2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }

    @Test
    public void testMinWindowSubstring3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        String result = solution.minWindow(s, t);
        assertEquals(expected, result);
    }
}
