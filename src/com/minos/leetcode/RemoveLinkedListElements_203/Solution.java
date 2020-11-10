package com.minos.leetcode.RemoveLinkedListElements_203;

import com.minos.leetcode.RemoveLinkedListElements_203.ListNode;

/**
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @Author: minos
 * @Date: 2020/10/18 19:10
 */
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                // 删除当前节点后，当前位置的新节点内容仍然可能是待删值，这里不应该把prev往后挪
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
               prev = prev.next;
            }
        }

        return head;
    }

    /**
     * 使用哨兵sentinel结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }

        return sentinel.next;
    }
}











