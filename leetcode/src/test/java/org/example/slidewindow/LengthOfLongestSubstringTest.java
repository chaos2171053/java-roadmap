package org.example.slidewindow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLongestSubstringTest {
    private final LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

    @Test
    public void testLengthOfLongestSubstring1() {
        String s = "abcabcbb";
        int expected = 3;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        String s = "bbbbb";
        int expected = 1;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        String s = "pwwkew";
        int expected = 3;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }
}
