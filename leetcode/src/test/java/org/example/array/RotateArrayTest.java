package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateArrayTest {

    @Test
    public void testRotate() {
        RotateArray rotateArray = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotateArray.rotate(nums1, k1);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums1);

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotateArray.rotate(nums2, k2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, nums2);

        int[] nums3 = {1, 2, 3, 4};
        int k3 = 4;
        rotateArray.rotate(nums3, k3);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums3);
    }
}
