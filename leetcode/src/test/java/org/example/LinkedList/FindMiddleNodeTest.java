package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMiddleNodeTest {

    @Test
    public void testFindMiddle_SingleNode() {
        ListNode head = ListNode.build(new int[]{1});
        FindMiddleNode finder = new FindMiddleNode();
        ListNode result = finder.findMiddle(head);
        assertEquals(1, result.val);
    }

    @Test
    public void testFindMiddle_OddNodes() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        FindMiddleNode finder = new FindMiddleNode();
        ListNode result = finder.findMiddle(head);
        assertEquals(3, result.val);
    }

    @Test
    public void testFindMiddle_EvenNodes() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5, 6});
        FindMiddleNode finder = new FindMiddleNode();
        ListNode result = finder.findMiddle(head);
        assertEquals(4, result.val);
    }
}
