package org.example.heap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class KthLargestElementTest {

    @Test
    public void testFindKthLargestExample1() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        assertEquals(5, kthLargestElement.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestExample2() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        assertEquals(4, kthLargestElement.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestSingleElement() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {1};
        int k = 1;
        assertEquals(1, kthLargestElement.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestDuplicates() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int k = 6;
        assertEquals(2, kthLargestElement.findKthLargest(nums, k));
    }

    @Test
    public void testFindKthLargestLargeK() {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {1, 5, 6, 3, 4, 2};
        int k = 1;
        assertEquals(6, kthLargestElement.findKthLargest(nums, k));
    }
}
