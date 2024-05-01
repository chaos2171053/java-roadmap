package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RemoveNthNodeFromEndOfListTest {

    // Helper method to convert ListNode to array
    private int[] listToArray(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int[] arr = new int[length];
        current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.val;
            current = current.next;
        }
        return arr;
    }

    @Test
    public void exampleTest1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(5);
        ListNode result = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        assertArrayEquals(listToArray(expected), listToArray(result));
    }

    @Test
    public void exampleTest2() {
        ListNode head = new ListNode(1);
        int n = 1;
        ListNode expected = null;
        ListNode result = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        assertArrayEquals(listToArray(expected), listToArray(result));
    }

    @Test
    public void exampleTest3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 1;
        ListNode expected = new ListNode(1);
        ListNode result = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        assertArrayEquals(listToArray(expected), listToArray(result));
    }
}
