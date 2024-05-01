package org.example.LinkedList;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//示例 2：
//
//输入：l1 = [], l2 = []
//输出：[]
//示例 3：
//
//输入：l1 = [], l2 = [0]
//输出：[0]

public class MergeTwoSortedLists2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        while(l1!=null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while(l2!=null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return  dummy.next;
    }
}
