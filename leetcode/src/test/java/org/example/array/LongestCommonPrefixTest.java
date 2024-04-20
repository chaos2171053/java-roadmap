package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {
    @Test
    public void testLongestCommonPrefix() {
        String[] strs1 = {"flower", "flow", "flight"};
        assertEquals("fl", LongestCommonPrefix.longestCommonPrefix(strs1));

        String[] strs2 = {"dog", "racecar", "car"};
        assertEquals("", LongestCommonPrefix.longestCommonPrefix(strs2));
    }
}