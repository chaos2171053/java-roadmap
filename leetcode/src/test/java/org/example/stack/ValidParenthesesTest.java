package org.example.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
    @Test
    public void testIsValid_Example1() {
        ValidParentheses solution = new ValidParentheses();

        String s = "()";
        assertTrue(solution.isValid(s));
    }

    @Test
    public void testIsValid_Example2() {
        ValidParentheses solution = new ValidParentheses();

        String s = "()[]{}";
        assertTrue(solution.isValid(s));
    }

    @Test
    public void testIsValid_Example3() {
        ValidParentheses solution = new ValidParentheses();

        String s = "(]";
        assertFalse(solution.isValid(s));
    }
}
