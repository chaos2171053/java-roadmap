package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testGetIntersectionNode_Example1() {
        ListNode headA = ListNode.build(new int[]{4, 1, 8, 4, 5});
        ListNode headB = ListNode.build(new int[]{5, 6, 1, 8, 4, 5});
        headB.next.next.next = headA.next.next;
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode expected = headA.next.next;
        ListNode result = solution.getIntersectionNode(headA, headB);
        assertEquals(expected, result);
    }

    @Test
    public void testGetIntersectionNode_Example2() {
        ListNode headA = ListNode.build(new int[]{2, 6, 4});
        ListNode headB = ListNode.build(new int[]{1, 5});
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode expected = null;
        ListNode result = solution.getIntersectionNode(headA, headB);
        assertEquals(expected, result);
    }

    @Test
    public void testGetIntersectionNode_Example3() {
        ListNode headA = ListNode.build(new int[]{1, 9, 1, 2, 4});
        ListNode headB = ListNode.build(new int[]{3, 2, 4});
        headB.next.next.next = headA.next.next.next;
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode expected = headA.next.next.next;
        ListNode result = solution.getIntersectionNode(headA, headB);
        assertEquals(expected, result);
    }
}
