package org.example.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDuplicateRemoverTest {

    @Test
    public void testRemoveDuplicatesWithLimit() {
        ArrayDuplicateRemover remover = new ArrayDuplicateRemover();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        assertEquals(5, remover.removeDuplicatesWithLimit(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        assertEquals(7, remover.removeDuplicatesWithLimit(nums2));
    }
}
