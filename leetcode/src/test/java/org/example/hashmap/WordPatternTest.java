package org.example.hashmap;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordPatternTest {

    @Test
    public void testWordPattern() {
        WordPattern solution = new WordPattern();

        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        assertTrue(solution.wordPattern(pattern1, s1));

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        assertFalse(solution.wordPattern(pattern2, s2));

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        assertFalse(solution.wordPattern(pattern3, s3));

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        assertFalse(solution.wordPattern(pattern4, s4));
    }
}
