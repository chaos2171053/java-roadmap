package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class SwapPairsTest {

    @Test
    public void testSwapPairs_Example1() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4});
        SwapPairs solution = new SwapPairs();
        ListNode expected = ListNode.build(new int[]{2, 1, 4, 3});
        ListNode result = solution.swapPairs(head);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testSwapPairs_Example2() {
        ListNode head = ListNode.build(new int[]{});
        SwapPairs solution = new SwapPairs();
        ListNode expected = ListNode.build(new int[]{});
        ListNode result = solution.swapPairs(head);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testSwapPairs_Example3() {
        ListNode head = ListNode.build(new int[]{1});
        SwapPairs solution = new SwapPairs();
        ListNode expected = ListNode.build(new int[]{1});
        ListNode result = solution.swapPairs(head);
        assertTrue(ListNode.compare(expected, result));
    }
}
