package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestPalindromeSubstringTest {

    @Test
    public void testLongestPalindrome_EmptyString() {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        // 测试用例1：空字符串
        String s1 = "";
        String expected1 = "";
        String result1 = solution.longestPalindrome(s1);
        assertEquals(expected1, result1);
    }

    @Test
    public void testLongestPalindrome_SingleCharacter() {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        // 测试用例2：单个字符
        String s2 = "a";
        String expected2 = "a";
        String result2 = solution.longestPalindrome(s2);
        assertEquals(expected2, result2);
    }

    @Test
    public void testLongestPalindrome_EvenLength() {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        // 测试用例3：偶数长度回文串 "bab"
        String s3 = "babad";
        String expected3 = "aba";
        String result3 = solution.longestPalindrome(s3);
        assertEquals(expected3, result3);
    }

    @Test
    public void testLongestPalindrome_OddLength() {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        // 测试用例4：奇数长度回文串 "aa"
        String s4 = "cbbd";
        String expected4 = "bb";
        String result4 = solution.longestPalindrome(s4);
        assertEquals(expected4, result4);
    }
}
