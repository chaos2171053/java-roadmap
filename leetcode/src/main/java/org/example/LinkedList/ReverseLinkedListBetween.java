package org.example.LinkedList;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
//请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
public class ReverseLinkedListBetween {
    //    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head == null || left >= right) return head;
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        // 找到需要反转的起始位置的前一个节点
//        ListNode prev = dummy;
//        for (int i = 1; i < left; i++) {
//            prev = prev.next;
//        }
//        // 反转链表的指定范围
//        ListNode curr = prev.next;
//        for (int i = left; i < right; i++) {
//            ListNode nextNode = curr.next;
//            curr.next = nextNode.next;
//            nextNode.next = prev.next;
//            prev.next = nextNode;
//        }
//
//        return dummy.next;
//    }
// 反转以 head 为起点的 n 个节点，返回新的头结点
    public ListNode reverseN(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 反转从第 m 个节点到第 n 个节点的子链表，并返回头结点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


}
