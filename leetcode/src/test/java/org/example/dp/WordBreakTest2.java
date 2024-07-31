package org.example.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordBreakTest2 {

    @Test
    public void testWordBreakExample1() {
        WordBreak2 wb = new WordBreak2();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        assertEquals(true, wb.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreakExample2() {
        WordBreak2 wb = new WordBreak2();
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        assertEquals(true, wb.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreakExample3() {
        WordBreak2 wb = new WordBreak2();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        assertEquals(false, wb.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreakEmptyString() {
        WordBreak2 wb = new WordBreak2();
        String s = "";
        List<String> wordDict = Arrays.asList("apple", "pen");
        assertEquals(true, wb.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreakSingleCharacter() {
        WordBreak2 wb = new WordBreak2();
        String s = "a";
        List<String> wordDict = Arrays.asList("a");
        assertEquals(true, wb.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreakMultipleCharacters() {
        WordBreak2 wb = new WordBreak2();
        String s = "abcde";
        List<String> wordDict = Arrays.asList("ab", "cd", "e");
        assertEquals(true, wb.wordBreak(s, wordDict));
    }
}

