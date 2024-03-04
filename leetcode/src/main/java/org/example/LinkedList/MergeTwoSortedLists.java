package org.example.LinkedList;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(l1!=null&& l2!=null){
            if(l1.val>l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else if(l1.val< l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1!=null){
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}
