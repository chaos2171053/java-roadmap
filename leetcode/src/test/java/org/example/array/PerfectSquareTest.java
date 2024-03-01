package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PerfectSquareTest {

    @Test
    public void testIsPerfectSquare_PerfectSquare() {
        PerfectSquare perfectSquare = new PerfectSquare();
        int num = 16;
        boolean expected = true; // 16是完全平方数
        boolean result = perfectSquare.isPerfectSquare(num);
        assertEquals(expected, result);
    }

    @Test
    public void testIsPerfectSquare_NotPerfectSquare() {
        PerfectSquare perfectSquare = new PerfectSquare();
        int num = 14;
        boolean expected = false; // 14不是完全平方数
        boolean result = perfectSquare.isPerfectSquare(num);
        assertEquals(expected, result);
    }

    @Test
    public void testIsPerfectSquare_Zero() {
        PerfectSquare perfectSquare = new PerfectSquare();
        int num = 0;
        boolean expected = true; // 0是完全平方数
        boolean result = perfectSquare.isPerfectSquare(num);
        assertEquals(expected, result);
    }

    @Test
    public void testIsPerfectSquare_One() {
        PerfectSquare perfectSquare = new PerfectSquare();
        int num = 1;
        boolean expected = true; // 1是完全平方数
        boolean result = perfectSquare.isPerfectSquare(num);
        assertEquals(expected, result);
    }
}
