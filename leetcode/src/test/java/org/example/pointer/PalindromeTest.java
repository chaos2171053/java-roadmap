package org.example.pointer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void testIsPalindromeWithValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testIsPalindromeWithInvalidPalindrome() {
        assertFalse(Palindrome.isPalindrome("race a car"));
    }

    @Test
    public void testIsPalindromeWithEmptyString() {
        assertTrue(Palindrome.isPalindrome(" "));
    }
}
