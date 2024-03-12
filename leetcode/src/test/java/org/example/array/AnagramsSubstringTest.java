package org.example.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class AnagramsSubstringTest {

    @Test
    public void testFindAnagrams_Case1() {
        AnagramsSubstring solution = new AnagramsSubstring();

        // Test case 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> expected1 = Arrays.asList(0, 6);
        List<Integer> result1 = solution.findAnagrams(s1, p1);
        assertArrayEquals(expected1.toArray(), result1.toArray());
    }

    @Test
    public void testFindAnagrams_Case2() {
        AnagramsSubstring solution = new AnagramsSubstring();

        // Test case 2
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> expected2 = Arrays.asList(0, 1, 2);
        List<Integer> result2 = solution.findAnagrams(s2, p2);
        assertArrayEquals(expected2.toArray(), result2.toArray());
    }

}


