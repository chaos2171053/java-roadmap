package org.example.LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReverseKGroupTest {
    @Test
    public void testReverseKGroup_2Nodes() {
        ReverseKGroup solution = new ReverseKGroup();

        // 创建链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ListNode.build(new int[] {1, 2, 3, 4, 5});

        // 反转每 2 个节点：2 -> 1 -> 4 -> 3 -> 5
        ListNode expected = ListNode.build(new int[] {2, 1, 4, 3, 5});
        ListNode result = solution.reverseKGroup(head, 2);
        assertEquals(ListNode.toList(expected), ListNode.toList(result));
    }

    @Test
    public void testReverseKGroup_3Nodes() {
        ReverseKGroup solution = new ReverseKGroup();

        // 创建链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ListNode.build(new int[] {1, 2, 3, 4, 5});

        // 反转每 3 个节点：3 -> 2 -> 1 -> 4 -> 5
        ListNode expected = ListNode.build(new int[] {3, 2, 1, 4, 5});
        ListNode result = solution.reverseKGroup(head, 3);
        assertEquals(ListNode.toList(expected), ListNode.toList(result));
    }
    @Test
    public void testReverseLinkedList() {
        ReverseKGroup solution = new ReverseKGroup();
        ListNode head = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.build(new int[]{5, 4, 3, 2, 1});
        ListNode result = solution.reverse(head,null);
        assertEquals(ListNode.toList(expected), ListNode.toList(result));
    }
    @Test
    public void testReverseLinkedListAToB() {
        ReverseKGroup solution = new ReverseKGroup();
        ListNode a = ListNode.build(new int[]{1,2,3,4,5});
        ListNode b = a;
        for (int i = 0; i < 3; i++) {
            b = b.next;
        }
        ListNode expected = ListNode.build(new int[]{3,2,1,4,5});
        ListNode result = solution.reverse(a,b);
        ListNode tail = ListNode.build(new int[]{4,5});
        ListNode head = result;
        while (head!=null && head.next!=null){
            head = head.next;
        }
        head.next = tail;
        assertEquals(ListNode.toList(expected), ListNode.toList(result));
    }
}

