package com.minos.leetcode.RemoveLinkedListElements_203;

/**
 *  利用递归实现删除链表中所有匹配的元素
 * @Author: minos
 * @Date: 2020/11/10 15:49
 */
public class Sulution2 {

    public ListNode removeElements(ListNode head, int val) {

        // 递归终止条件
        if (head ==null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        }else {
            head.next = res;
            return head;
        }
    }
}
