package org.example.LinkedList;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//示例 2：
//
//输入：head = [5], left = 1, right = 1
//输出：[5]

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        // Step 0: Define dummy node to handle cases where left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move to the node just before the left position
        ListNode preLeft = dummy;
        for (int i = 0; i < left - 1; i++) {
            preLeft = preLeft.next;
        }

        // Step 2: Start reversing nodes between left and right
        ListNode prev = preLeft.next;
        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 3: Adjust pointers for left and right nodes
        preLeft.next.next = current;
        preLeft.next = prev;

        return dummy.next;
    }
}
