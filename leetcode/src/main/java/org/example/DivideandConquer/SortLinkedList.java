package org.example.DivideandConquer;


//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//
//
//示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//示例 3：
//
//输入：head = []
//输出：[]
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next ==null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1!=null& list2!=null){
            if(list1.val< list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while(head!=null && head.next!=null){
            midPrev  = (midPrev==null)?head:midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
