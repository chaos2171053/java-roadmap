package org.example.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateLettersTest {

    @Test
    public void testRemoveDuplicateLetters1() {
        String input = "bcabc";
        String expectedOutput = "abc";
        String actualOutput = RemoveDuplicateLetters.removeDuplicateLetters(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testRemoveDuplicateLetters2() {
        String input = "cbacdcbc";
        String expectedOutput = "acdb";
        String actualOutput = RemoveDuplicateLetters.removeDuplicateLetters(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
