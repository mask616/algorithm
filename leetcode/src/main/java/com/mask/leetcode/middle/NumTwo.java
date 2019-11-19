package com.mask.leetcode.middle;


import com.mask.leetcode.middle.bean.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class NumTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        boolean yichu = false;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode pre = null;
        do {
            if (temp1 == null) {
                temp1 = new ListNode(0);
            }
            if (temp2 == null) {
                temp2 = new ListNode(0);
            }
            int sum = temp1.val + temp2.val;
            if (yichu) {
                sum++;
            }

            ListNode node ;
            if (sum >= 10) {
                yichu = true;
                node = new ListNode(sum - 10);
            } else {
                yichu = false;
                node = new ListNode(sum);
            }
            if (result == null) {
                result = node;
                pre = result;
            }

            if (current == null) {
                current = node;
            } else {
                current = node;
                pre.next = node;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
            pre = current;
        } while (temp1 != null || temp2 != null || yichu);

        return result;
    }

    public void printListNode(ListNode listNode) {
        ListNode temp = listNode;
        do {
            System.out.println(temp.val);
            temp = temp.next;
        } while (temp != null);
    }

    /**
     * 标准答案
     * @param l1
     *
     * @param l2
     * @return
     */
    public ListNode standard(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

}
