package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleStartTest {

    @Test
    public void testDetectCycle_NoCycle() {
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        LinkedListCycleDetector detector = new LinkedListCycleDetector();
        ListNode result = detector.detectCycleStart(head);
        assertEquals(null, result);
    }

    @Test
    public void testDetectCycle_Cycle() {
        ListNode head = ListNode.buildWithCycle(new int[]{1, 2, 3, 4, 5}, 2);
        LinkedListCycleDetector detector = new LinkedListCycleDetector();
        ListNode result = detector.detectCycleStart(head);
        assertEquals(3, result.val);
    }

    // LinkedListCycleDetector 的实现与前面相同
}

