package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {

    @Test
    public void testMergeTwoLists_Example1() {
        ListNode l1 = ListNode.build(new int[]{1, 2, 4});
        ListNode l2 = ListNode.build(new int[]{1, 3, 4});
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode expected = ListNode.build(new int[]{1, 1, 2, 3, 4, 4});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testMergeTwoLists_Example2() {
        ListNode l1 = ListNode.build(new int[]{});
        ListNode l2 = ListNode.build(new int[]{});
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode expected = null;
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testMergeTwoLists_Example3() {
        ListNode l1 = ListNode.build(new int[]{});
        ListNode l2 = ListNode.build(new int[]{0});
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode expected = ListNode.build(new int[]{0});
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertTrue(ListNode.compare(expected, result));
    }
}
