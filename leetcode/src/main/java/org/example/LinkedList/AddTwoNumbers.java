package org.example.LinkedList;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
//示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//示例 2：
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//示例 3：
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//提示：
//
//每个链表中的节点数在范围 [1, 100] 内
//0 <= Node.val <= 9
//题目数据保证列表表示的数字不含前导零
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummy = new ListNode();
        dummy = result;
        int sum = 0;
        int ten = 0;
        while(l1 !=null && l2!=null){
            sum = l1.val+l2.val+ten;
            if(sum>=10){
                ten = 1;
                sum = sum %10;
            }else {
                ten = 0;
            }
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            sum = l1.val+ten;
            if(sum>=10){
                ten = 1;
                sum = sum %10;
            }else {
                ten = 0;
            }
            result.next = l1;
            result.next.val = sum;
            l1 = l1.next;
            result = result.next;
        }
        while (l2!=null){
            sum = l2.val+ten;
            if(sum>=10){
                ten = 1;
                sum = sum %10;
            }else {
                ten = 0;
            }
            result.next = l2;
            result.next.val = sum;
            l2 = l2.next;
            result = result.next;
        }
        if(ten==1){
            result.next = new ListNode(1);
        }
        return  dummy.next;
    }
}
