package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveNthNodeFromEndTest {

    @Test
    public void testRemoveNthFromEnd_Example1() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        ListNode expected = ListNode.build(new int[]{1, 2, 3, 5});
        ListNode result = solution.removeNthFromEnd(head, n);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testRemoveNthFromEnd_Example2() {
        ListNode head = ListNode.build(new int[]{1, 2});
        int n = 1;
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        ListNode expected = ListNode.build(new int[]{1});
        ListNode result = solution.removeNthFromEnd(head, n);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testRemoveNthFromEnd_Example3() {
        ListNode head = ListNode.build(new int[]{1});
        int n = 1;
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();
        ListNode expected = null;
        ListNode result = solution.removeNthFromEnd(head, n);
        assertTrue(ListNode.compare(expected, result));
    }
}

