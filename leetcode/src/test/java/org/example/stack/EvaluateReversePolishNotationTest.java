package org.example.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluateReversePolishNotationTest {
    @Test
    public void testEvaluateExpression() {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        assertEquals(9, solution.evalRPN(tokens1));

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        assertEquals(6, solution.evalRPN(tokens2));

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, solution.evalRPN(tokens3));
    }
}
