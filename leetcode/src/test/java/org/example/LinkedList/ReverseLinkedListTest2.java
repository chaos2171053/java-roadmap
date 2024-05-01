package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseLinkedListTest2 {
    @Test
    public void testReverseLinkedList() {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int left1 = 2;
        int right1 = 4;
        ReverseLinkedList2 solution = new ReverseLinkedList2();
        ListNode reversed1 = solution.reverseBetween(head1, left1, right1);
        int[] expected1 = {1, 4, 3, 2, 5};
        assertArrayEquals(expected1, toArray(reversed1));

        // Example 2
        ListNode head2 = new ListNode(5);
        int left2 = 1;
        int right2 = 1;
        ListNode reversed2 = solution.reverseBetween(head2, left2, right2);
        int[] expected2 = {5};
        assertArrayEquals(expected2, toArray(reversed2));
    }

    private int[] toArray(ListNode head) {
        if (head == null) return new int[0];
        ListNode current = head;
        int size = getSize(head);
        int[] array = new int[size];
        int index = 0;
        while (current != null) {
            array[index++] = current.val;
            current = current.next;
        }
        return array;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}
