package org.example.slidewindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindSubstringTest {
    private final FindSubstring solution = new FindSubstring();

    @Test
    public void testFindSubstring1() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        int[] expected = {0, 9};
        int[] result = solution.findSubstring(s, words);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFindSubstring2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        int[] expected = {};
        int[] result = solution.findSubstring(s, words);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFindSubstring3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        int[] expected = {6, 9, 12};
        int[] result = solution.findSubstring(s, words);
        assertArrayEquals(expected, result);
    }
}
