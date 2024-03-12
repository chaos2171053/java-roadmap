package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingTest {

    @Test
    public void testLengthOfLongestSubstring_SingleCharacter() {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        String s = "a";
        int expected = 1;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }

    @Test
    public void testLengthOfLongestSubstring_AllRepeatingCharacters() {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        String s = "aaaaa";
        int expected = 1;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }

    @Test
    public void testLengthOfLongestSubstring_DistinctCharacters() {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();

        String s = "abcabcbb";
        int expected = 3;
        int result = solution.lengthOfLongestSubstring(s);
        assertEquals(expected, result);
    }
}

