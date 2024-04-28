package org.example.range;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SummaryRangesTest {
    @Test
    public void testSummaryRanges_Example1() {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = Arrays.asList("0->2", "4->5", "7");
        List<String> result = solution.summaryRanges(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testSummaryRanges_Example2() {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> expected = Arrays.asList("0", "2->4", "6", "8->9");
        List<String> result = solution.summaryRanges(nums);
        assertEquals(expected, result);
    }
}
