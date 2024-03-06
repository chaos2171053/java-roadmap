package org.example.LinkedList;

//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);

        return newHead;
    }
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    public ListNode reverse(ListNode head,ListNode headB) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while(cur!=headB){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
     return  prev;
    }
}
