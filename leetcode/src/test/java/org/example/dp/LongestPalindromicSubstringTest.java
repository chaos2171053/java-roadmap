package org.example.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubstringTest {
    @Test
    public void testExample1() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        boolean isValid = result.equals("bab") || result.equals("aba");
        assertEquals(true, isValid);
    }

    @Test
    public void testExample2() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "cbbd";
        assertEquals("bb", solution.longestPalindrome(s));
    }

    @Test
    public void testSingleCharacter() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "a";
        assertEquals("a", solution.longestPalindrome(s));
    }

    @Test
    public void testEmptyString() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "";
        assertEquals("", solution.longestPalindrome(s));
    }

    @Test
    public void testNoPalindrome() {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String s = "abc";
        String result = solution.longestPalindrome(s);
        boolean isValid = result.equals("a") || result.equals("b") || result.equals("c");
        assertEquals(true, isValid);
    }
}
