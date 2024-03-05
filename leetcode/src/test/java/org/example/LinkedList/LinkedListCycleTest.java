package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleTest {

    @Test
    public void testHasCycle_NoCycle() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        LinkedListCycleDetector detector = new LinkedListCycleDetector();
        boolean result = detector.hasCycle(head);
        assertEquals(false, result);
    }

    @Test
    public void testHasCycle_Cycle() {
        ListNode head = ListNode.buildWithCycle(new int[]{1, 2, 3, 4, 5}, 2);
        LinkedListCycleDetector detector = new LinkedListCycleDetector();
        boolean result = detector.hasCycle(head);
        assertEquals(true, result);
    }

    // LinkedListCycleDetector 的实现与前面相同
}
