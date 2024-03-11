package org.example.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumArrayTest {

    @Test
    public void testSumRange_FirstRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        assertEquals(1, numArray.sumRange(0, 2));
    }

    @Test
    public void testSumRange_SecondRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        assertEquals(-1, numArray.sumRange(2, 5));
    }

    @Test
    public void testSumRange_ThirdRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        assertEquals(-3, numArray.sumRange(0, 5));
    }
}

