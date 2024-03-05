package org.example.LinkedList;

// 获取单链表的倒数第 k 个节点
public class GetKthFromEnd {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return  null;
        }
        ListNode fast = head;
        for (int i = 0; i < k && fast!=null; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
