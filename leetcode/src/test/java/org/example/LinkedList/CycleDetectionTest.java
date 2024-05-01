package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CycleDetectionTest {
    @Test
    public void testHasCycleWithCycle() {
        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;  // Cycle
        CycleDetection solution = new CycleDetection();
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void testHasCycleWithCycleAtFirstNode() {
        // Create a linked list with a cycle at the first node
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;  // Cycle
        CycleDetection solution = new CycleDetection();
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void testHasCycleWithoutCycle() {
        // Create a linked list without a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = null;
        CycleDetection solution = new CycleDetection();
        assertFalse(solution.hasCycle(head));
    }
    @Test
    public void testHasCycleWithNegativePos() {
        // Create a linked list without a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = null;
        CycleDetection solution = new CycleDetection();
        assertFalse(solution.hasCycle(head));
    }
}
