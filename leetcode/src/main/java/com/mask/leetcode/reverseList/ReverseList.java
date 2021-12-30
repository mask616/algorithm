package com.mask.leetcode.reverseList;

/**
 * 反转列表
 */
public class ReverseList {

	public ListNode reverseList(ListNode head) {
		return recur(head, null);
	}

	private ListNode recur(ListNode curr, ListNode pre) {
		if (curr == null) return pre;
		 ListNode res = recur(curr.next, curr);
		curr.next = pre;
		 return res;
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);

		new ReverseList().reverseList(listNode);
	}

}

class ListNode{
	int val;

	ListNode next;

	ListNode(int x){
		this.val = x;
	}
}