package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrapWaterTest {
    @Test
    public void testTrap1() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int result = TrapWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testTrap2() {
        int[] height = {4,2,0,3,2,5};
        int expected = 9;
        int result = TrapWater.trap(height);
        assertEquals(expected, result);
    }
}
