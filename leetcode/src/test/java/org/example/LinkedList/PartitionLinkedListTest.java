package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PartitionLinkedListTest {
    @Test
    public void testPartition() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        int x1 = 3;
        ListNode expected1 = new ListNode(1);
        expected1.next = new ListNode(2);
        expected1.next.next = new ListNode(2);
        expected1.next.next.next = new ListNode(4);
        expected1.next.next.next.next = new ListNode(3);
        expected1.next.next.next.next.next = new ListNode(5);
        ListNode result1 = new PartitionLinkedList().partition(head1, x1);
        while (expected1 != null && result1 != null) {
            assertEquals(expected1.val, result1.val);
            expected1 = expected1.next;
            result1 = result1.next;
        }
        assertNull(expected1);
        assertNull(result1);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        int x2 = 2;
        ListNode expected2 = new ListNode(1);
        expected2.next = new ListNode(2);
        ListNode result2 = new PartitionLinkedList().partition(head2, x2);
        while (expected2 != null && result2 != null) {
            assertEquals(expected2.val, result2.val);
            expected2 = expected2.next;
            result2 = result2.next;
        }
        assertNull(expected2);
        assertNull(result2);
    }
}
