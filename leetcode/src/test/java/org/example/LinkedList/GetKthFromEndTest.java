package org.example.LinkedList;

import org.junit.Test;

import static org.example.LinkedList.GetKthFromEnd.getKthFromEnd;
import static org.junit.Assert.assertEquals;

public class GetKthFromEndTest {
    @Test
    public void testGetKthFromEnd_LastNode() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result = getKthFromEnd(head, 1);
        assertEquals(5, result.val);
    }

    @Test
    public void testGetKthFromEnd_MiddleNode() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result = getKthFromEnd(head, 3);
        assertEquals(3, result.val);
    }

    @Test
    public void testGetKthFromEnd_FirstNode() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode result = getKthFromEnd(head, 5);
        assertEquals(1, result.val);
    }


    @Test
    public void testGetKthFromEnd_EmptyList() {
        ListNode result = getKthFromEnd(null, 1);
        assertEquals(null, result);
    }
}
