package org.example.pointer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubsequenceTest {

    private final SubsequenceChecker checker = new SubsequenceChecker();

    @Test
    public void testIsSubsequenceTrue() {
        assertTrue(checker.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void testIsSubsequenceFalse() {
        assertFalse(checker.isSubsequence("axc", "ahbgdc"));
    }
}
