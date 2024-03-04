package org.example.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeKSortedListsTest {

    @Test
    public void testMergeKLists_Example1() {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.build(new int[]{1, 4, 5});
        lists[1] = ListNode.build(new int[]{1, 3, 4});
        lists[2] = ListNode.build(new int[]{2, 6});
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode expected = ListNode.build(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        ListNode result = solution.mergeKLists(lists);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testMergeKLists_Example2() {
        ListNode[] lists = new ListNode[0];
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode expected = null;
        ListNode result = solution.mergeKLists(lists);
        assertTrue(ListNode.compare(expected, result));
    }

    @Test
    public void testMergeKLists_Example3() {
        ListNode[] lists = new ListNode[1];
        lists[0] = ListNode.build(new int[]{});
        MergeKSortedLists solution = new MergeKSortedLists();
        ListNode expected = ListNode.build(new int[]{});
        ListNode result = solution.mergeKLists(lists);
        assertTrue(ListNode.compare(expected, result));
    }
}

