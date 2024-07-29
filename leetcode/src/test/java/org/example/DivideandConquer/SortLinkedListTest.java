package org.example.DivideandConquer;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class SortLinkedListTest {
    @Test
    public void testSortListWithExample1() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        SortLinkedList sorter = new SortLinkedList();
        ListNode sorted = sorter.sortList(head);

        assertArrayEquals(new int[]{1, 2, 3, 4}, listToArray(sorted));
    }

    @Test
    public void testSortListWithExample2() {
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        SortLinkedList sorter = new SortLinkedList();
        ListNode sorted = sorter.sortList(head);

        assertArrayEquals(new int[]{-1, 0, 3, 4, 5}, listToArray(sorted));
    }

    @Test
    public void testSortListWithEmptyList() {
        ListNode head = null;
        SortLinkedList sorter = new SortLinkedList();
        ListNode sorted = sorter.sortList(head);

        assertNull(sorted);
    }

    @Test
    public void testSortListWithSingleElement() {
        ListNode head = new ListNode(1);
        SortLinkedList sorter = new SortLinkedList();
        ListNode sorted = sorter.sortList(head);

        assertArrayEquals(new int[]{1}, listToArray(sorted));
    }

    private int[] listToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
