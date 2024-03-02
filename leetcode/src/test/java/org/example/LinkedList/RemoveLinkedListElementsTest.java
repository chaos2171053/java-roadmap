package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveLinkedListElementsTest {

    @Test
    public void testRemoveElements_Example1() {
        ListNode head = ListNode.build(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val = 6;
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode expected = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.removeElements(head, val);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testRemoveElements_Example2() {
        ListNode head = ListNode.build(new int[]{});
        int val = 1;
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode expected = null;
        ListNode result = solution.removeElements(head, val);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testRemoveElements_Example3() {
        ListNode head = ListNode.build(new int[]{7, 7, 7, 7});
        int val = 7;
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode expected = null;
        ListNode result = solution.removeElements(head, val);
        assertTrue(ListNode.compare(expected, result));
    }
}

