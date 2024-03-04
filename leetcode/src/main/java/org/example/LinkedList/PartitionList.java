package org.example.LinkedList;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return  null;
        }
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 =dummy1;
        ListNode p2 = dummy2;
        while (head!=null){
            if(head.val<x){
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }

            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
