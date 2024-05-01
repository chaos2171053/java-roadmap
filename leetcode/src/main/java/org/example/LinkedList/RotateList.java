package org.example.LinkedList;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        // Count the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Adjust k to avoid unnecessary rotations
        k = k % length;
        if (k == 0) return head; // No need to rotate

        // Find the new tail (the node at position length - k - 1)
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Update pointers
        tail.next = head; // Connect the original tail with the original head to form a cycle
        head = newTail.next; // The node after newTail becomes the new head
        newTail.next = null; // The new tail's next pointer should be null

        return head;
    }
}
