package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RemoveDuplicatesFromSortedListTest {
    @Test
    public void testRemoveDuplicates() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next.next = new ListNode(5);

        ListNode expected1 = new ListNode(1);
        expected1.next = new ListNode(2);
        expected1.next.next = new ListNode(5);

        ListNode result1 = new RemoveDuplicatesFromSortedList().deleteDuplicates(head1);
        assertTrue(compareLists(expected1, result1));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);

        ListNode expected2 = new ListNode(2);
        expected2.next = new ListNode(3);

        ListNode result2 = new RemoveDuplicatesFromSortedList().deleteDuplicates(head2);
        assertTrue(compareLists(expected2, result2));
    }

    private boolean compareLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
