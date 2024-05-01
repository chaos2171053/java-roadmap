package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeTwoSortedListsTest2 {
    @Test
    public void testMergeTwoLists_Example1() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode expected = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        MergeTwoSortedLists2 solution = new MergeTwoSortedLists2();
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    @Test
    public void testMergeTwoLists_Example2() {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode expected = null;
        MergeTwoSortedLists2 solution = new MergeTwoSortedLists2();
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    @Test
    public void testMergeTwoLists_Example3() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);
        MergeTwoSortedLists2 solution = new MergeTwoSortedLists2();
        ListNode result = solution.mergeTwoLists(l1, l2);
        assertLinkedListEquals(expected, result);
    }

    private void assertLinkedListEquals(ListNode expected, ListNode result) {
        while (expected != null && result != null) {
            assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }
        assertNull(expected);
        assertNull(result);
    }
}
