package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CopyListWithRandomPointerTest {
    @Test
    public void testCopyRandomList_Example1() {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node result = solution.copyRandomList(node1);
        assertLinkedListEquals(node1, result);
    }

    @Test
    public void testCopyRandomList_Example2() {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node node1 = new Node(1);
        Node node2 = new Node(2);

        node1.next = node2;
        node1.random = node2;
        node2.random = node2;

        Node result = solution.copyRandomList(node1);
        assertLinkedListEquals(node1, result);
    }

    @Test
    public void testCopyRandomList_Example3() {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node2.random = node1;

        Node result = solution.copyRandomList(node1);
        assertLinkedListEquals(node1, result);
    }

    private void assertLinkedListEquals(Node expected, Node result) {
        while (expected != null && result != null) {
            assertEquals(expected.val, result.val);
            if (expected.random == null) {
                assertNull(result.random);
            } else {
                assertNotNull(result.random);
                assertEquals(expected.random.val, result.random.val);
            }
            expected = expected.next;
            result = result.next;
        }
        assertNull(expected);
        assertNull(result);
    }
}
