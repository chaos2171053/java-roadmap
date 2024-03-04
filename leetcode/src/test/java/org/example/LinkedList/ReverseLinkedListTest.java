package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void testReverseList_Example1() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode expected = ListNode.build(new int[]{5, 4, 3, 2, 1});
        ListNode result = solution.reverseList(head);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testReverseList_EmptyList() {
        ListNode head = null;
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode expected = null;
        ListNode result = solution.reverseList(head);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testReverseList_SingleNode() {
        ListNode head = new ListNode(1);
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode expected = new ListNode(1);
        ListNode result = solution.reverseList(head);
        assertTrue(ListNode.compare(expected, result));
    }
}
