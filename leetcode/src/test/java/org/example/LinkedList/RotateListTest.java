package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RotateListTest {
    @Test
    public void testRotateList() {
        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int k1 = 2;
        ListNode expected1 = new ListNode(4);
        expected1.next = new ListNode(5);
        expected1.next.next = new ListNode(1);
        expected1.next.next.next = new ListNode(2);
        expected1.next.next.next.next = new ListNode(3);
        ListNode result1 = new RotateList().rotateRight(head1, k1);
        assertTrue(compareLinkedLists(expected1, result1));

        // Test case 2
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        int k2 = 4;
        ListNode expected2 = new ListNode(2);
        expected2.next = new ListNode(0);
        expected2.next.next = new ListNode(1);
        ListNode result2 = new RotateList().rotateRight(head2, k2);
        assertTrue(compareLinkedLists(expected2, result2));
    }

    // Helper method to compare two linked lists
    private boolean compareLinkedLists(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }
}
