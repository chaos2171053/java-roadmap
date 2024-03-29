package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WordBreakTest {

    @Test
    public void testWordBreak() {
        String s1 = "leetcode";
        String[] wordDict1 = {"leet", "code"};
        assertEquals(true, WordBreak.wordBreak(s1, Arrays.asList(wordDict1)));

        String s2 = "applepenapple";
        String[] wordDict2 = {"apple", "pen"};
        assertEquals(true, WordBreak.wordBreak(s2, Arrays.asList(wordDict2)));

        String s3 = "catsandog";
        String[] wordDict3 = {"cats", "dog", "sand", "and", "cat"};
        assertEquals(false, WordBreak.wordBreak(s3, Arrays.asList(wordDict3)));

        String s4 = "applebanana";
        String[] wordDict4 = {"apple", "banana"};
        assertEquals(true, WordBreak.wordBreak(s4, Arrays.asList(wordDict4)));

        String s5 = "aaaaaaa";
        String[] wordDict5 = {"aaa", "aaaa"};
        assertEquals(true, WordBreak.wordBreak(s5, Arrays.asList(wordDict5)));

        String s6 = "catsanddog";
        String[] wordDict6 = {"cat", "cats", "and", "sand", "dog"};
        assertEquals(true, WordBreak.wordBreak(s6, Arrays.asList(wordDict6)));
    }
}


