package org.example.LinkedList;

// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fastIndex = dummy;
        ListNode slowIndex = dummy;
        for (int i = 0; i < n+1; i++) {
            fastIndex = fastIndex.next;
        }
        while(fastIndex!=null){
            fastIndex = fastIndex.next;
            slowIndex =slowIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return dummy.next;
    }
}
