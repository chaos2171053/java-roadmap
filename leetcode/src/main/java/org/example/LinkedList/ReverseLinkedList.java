package org.example.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode temp = null;
//        while (cur != null) {
//            temp = cur.next;// 保存下一个节点
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//        return prev;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return last;
    }
}
