package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutationInStringTest {

    @Test
    public void testCheckInclusion_Example1() {
        PermutationInString solution = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean expected = true;
        boolean result = solution.checkInclusion(s1, s2);
        assertEquals(expected, result);
    }

    @Test
    public void testCheckInclusion_Example2() {
        PermutationInString solution = new PermutationInString();

        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean expected = false;
        boolean result = solution.checkInclusion(s1, s2);
        assertEquals(expected, result);
    }
}

