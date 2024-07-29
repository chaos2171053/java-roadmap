package org.example.backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GenerateParenthesesTest {

    @Test
    public void testGenerateParenthesisWithThreePairs() {
        GenerateParentheses genParen = new GenerateParentheses();
        int n = 3;
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> result = genParen.generateParenthesis(n);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testGenerateParenthesisWithOnePair() {
        GenerateParentheses genParen = new GenerateParentheses();
        int n = 1;
        List<String> expected = Arrays.asList("()");
        List<String> result = genParen.generateParenthesis(n);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testGenerateParenthesisWithZeroPairs() {
        GenerateParentheses genParen = new GenerateParentheses();
        int n = 0;
        List<String> expected = Arrays.asList("");
        List<String> result = genParen.generateParenthesis(n);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testGenerateParenthesisWithTwoPairs() {
        GenerateParentheses genParen = new GenerateParentheses();
        int n = 2;
        List<String> expected = Arrays.asList("(())", "()()");
        List<String> result = genParen.generateParenthesis(n);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }
}

