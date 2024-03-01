package org.example.array;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SqrtTest {

    @Test
    public void testMySqrt_SquareOfPerfectSquare() {
        Sqrt sqrt = new Sqrt();
        int x = 16;
        int expected = 4; // 16的算术平方根是4
        int result = sqrt.mySqrt(x);
        assertEquals(expected, result);
    }

    @Test
    public void testMySqrt_SquareOfNonPerfectSquare() {
        Sqrt sqrt = new Sqrt();
        int x = 8;
        int expected = 2; // 8的算术平方根是约为2.828的2
        int result = sqrt.mySqrt(x);
        assertEquals(expected, result);
    }

    @Test
    public void testMySqrt_Zero() {
        Sqrt sqrt = new Sqrt();
        int x = 0;
        int expected = 0; // 0的算术平方根是0
        int result = sqrt.mySqrt(x);
        assertEquals(expected, result);
    }

    @Test
    public void testMySqrt_One() {
        Sqrt sqrt = new Sqrt();
        int x = 1;
        int expected = 1; // 1的算术平方根是1
        int result = sqrt.mySqrt(x);
        assertEquals(expected, result);
    }
}
