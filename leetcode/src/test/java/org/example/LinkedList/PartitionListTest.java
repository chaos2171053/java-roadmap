package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class PartitionListTest {

    @Test
    public void testPartition_Example1() {
        ListNode head = ListNode.build(new int[]{1, 4, 3, 2, 5, 2});
        int x = 3;
        PartitionList solution = new PartitionList();
        ListNode expected = ListNode.build(new int[]{1, 2, 2, 4, 3, 5});
        ListNode result = solution.partition(head, x);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testPartition_Example2() {
        ListNode head = ListNode.build(new int[]{2, 1});
        int x = 2;
        PartitionList solution = new PartitionList();
        ListNode expected = ListNode.build(new int[]{1, 2});
        ListNode result = solution.partition(head, x);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testPartition_Example3() {
        ListNode head = ListNode.build(new int[]{1});
        int x = 0;
        PartitionList solution = new PartitionList();
        ListNode expected = ListNode.build(new int[]{1});
        ListNode result = solution.partition(head, x);
        assertTrue(ListNode.compare(expected, result));
    }
}

