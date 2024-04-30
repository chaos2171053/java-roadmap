package org.example.stack;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testBasicCalculator() {
        Calculator calculator = new Calculator();

        String s1 = "1 + 1";
        assertEquals(2, calculator.calculate(s1));

        String s2 = " 2-1 + 2 ";
        assertEquals(3, calculator.calculate(s2));

        String s3 = "(1+(4+5+2)-3)+(6+8)";
        assertEquals(23, calculator.calculate(s3));
    }
}
