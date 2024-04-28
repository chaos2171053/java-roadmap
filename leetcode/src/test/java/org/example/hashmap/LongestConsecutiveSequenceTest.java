package org.example.hashmap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequenceTest {
    @Test
    public void testLongestConsecutiveSequenceExample1() {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int expected = 4;
        int result = solution.longestConsecutive(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testLongestConsecutiveSequenceExample2() {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected = 9;
        int result = solution.longestConsecutive(nums);
        assertEquals(expected, result);
    }
}
