package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CanPartitionTest {

    @Test
    public void testCanPartition() {
        int[] nums1 = {1, 5, 11, 5};
        assertTrue(CanPartition.canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        assertFalse(CanPartition.canPartition(nums2));
    }
}
