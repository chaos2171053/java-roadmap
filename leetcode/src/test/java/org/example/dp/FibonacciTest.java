package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void testFibonacci() {
        int n = 6;
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fib(n);
        assertEquals(8, result);
    }
}
