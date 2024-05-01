package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {
    @Test
    public void testAddTwoNumbers_Example1() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddTwoNumbers_Example2() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAddTwoNumbers_Example3() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode expected = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        assertArrayEquals(expected, result);
    }

    private void assertArrayEquals(ListNode expected, ListNode result) {
        while (expected != null && result != null) {
            assertEquals(expected.val, result.val);
            expected = expected.next;
            result = result.next;
        }
        assertNull(expected);
        assertNull(result);
    }
}
