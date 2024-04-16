package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MajorityElementTest {

    @Test
    public void testMajorityElement() {
        MajorityElement solution = new MajorityElement();

//        // Example 1
//        int[] nums1 = {3, 2, 3};
//        assertEquals(3, solution.majorityElement(nums1));

        // Example 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, solution.majorityElement(nums2));
    }
}
