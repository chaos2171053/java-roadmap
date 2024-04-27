package org.example.hashmap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HappyNumberTest {
    @Test
    public void testHappyNumber_Example1() {
        HappyNumber solution = new HappyNumber();
        int n = 19;
        assertTrue(solution.isHappy(n));
    }

    @Test
    public void testHappyNumber_Example2() {
        HappyNumber solution = new HappyNumber();
        int n = 2;
        assertFalse(solution.isHappy(n));
    }
}
