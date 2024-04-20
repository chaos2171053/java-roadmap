package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProductExceptSelfTest {

    @Test
    public void testProductExceptSelf() {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] expected1 = {24, 12, 8, 6};
        assertArrayEquals(expected1, productExceptSelf.productExceptSelf(nums1));

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] expected2 = {0, 0, 9, 0, 0};
        assertArrayEquals(expected2, productExceptSelf.productExceptSelf(nums2));
    }
}