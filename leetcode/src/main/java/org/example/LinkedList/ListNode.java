package org.example.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 辅助方法：从数组构建链表
    public static ListNode build(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 辅助方法：比较两个链表是否相同
    public static boolean compare(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
    public static ListNode buildWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode cycleStart = null;
        ListNode tail = head;

        // 构建链表
        for (int i = 1; i < values.length; i++) {
            tail.next = new ListNode(values[i]);
            tail = tail.next;
            if (i == pos) cycleStart = tail; // 设置环的起始节点
        }

        // 如果设置了环的起始节点，则将链表尾部连接到起始节点
        if (cycleStart != null) tail.next = cycleStart;

        return head;
    }
    // 将链表转换为 List
    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}

