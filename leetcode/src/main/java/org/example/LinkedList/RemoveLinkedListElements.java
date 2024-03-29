package org.example.LinkedList;

//题意：删除链表中等于给定值 val 的所有节点。
//
//示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
//
//示例 2： 输入：head = [], val = 1 输出：[]
//
//示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr!=null){
            if(curr.val==val){
                prev.next = curr.next;
            }else {
                prev = curr;

            }
            curr = curr.next;
        }
        return dummy.next;

//        if (head == null) {
//            return head;
//        }
//        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
//        ListNode dummy = new ListNode(-1, head);
//        ListNode pre = dummy;
//        ListNode cur = head;
//        while (cur != null) {
//            if (cur.val == val) {
//                pre.next = cur.next;
//            } else {
//                pre = cur;
//            }
//            cur = cur.next;
//        }
//        return dummy.next;
    }
}
