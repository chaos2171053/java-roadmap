package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementStrStrTest {

    @Test
    public void testStrStr1() {
        ImplementStrStr solution = new ImplementStrStr();
        String haystack = "sadbutsad";
        String needle = "sad";
        int expected = 0;
        int result = solution.strStr(haystack, needle);
        assertEquals(expected, result);
    }

    @Test
    public void testStrStr2() {
        ImplementStrStr solution = new ImplementStrStr();
        String haystack = "leetcode";
        String needle = "leeto";
        int expected = -1;
        int result = solution.strStr(haystack, needle);
        assertEquals(expected, result);
    }

    // You can add more test cases here...
}
