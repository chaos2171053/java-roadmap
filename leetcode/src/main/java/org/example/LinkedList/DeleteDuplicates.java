package org.example.LinkedList;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            if(fast.val!=slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        if(slow!=null){
            slow.next = null;
        }

        return head;
    }
}
