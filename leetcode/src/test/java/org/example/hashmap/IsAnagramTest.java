package org.example.hashmap;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsAnagramTest {

    @Test
    public void testIsAnagram() {
        IsAnagram solution = new IsAnagram();

        String s1 = "anagram";
        String t1 = "nagaram";
        assertTrue(solution.isAnagram(s1, t1));

        String s2 = "rat";
        String t2 = "car";
        assertFalse(solution.isAnagram(s2, t2));

        String s3 = "hello";
        String t3 = "world";
        assertFalse(solution.isAnagram(s3, t3));

        String s4 = "listen";
        String t4 = "silent";
        assertTrue(solution.isAnagram(s4, t4));
    }
}
