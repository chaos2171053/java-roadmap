package org.example.LinkedList;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseKGroupLinkedListTest {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode expected = new ListNode(2);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(4);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(5);
        ListNode actual = new ReverseKGroupLinkedList().reverseKGroup(head, k);
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 3;
        ListNode expected = new ListNode(3);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(1);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(5);
        ListNode actual = new ReverseKGroupLinkedList().reverseKGroup(head, k);
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }
}

