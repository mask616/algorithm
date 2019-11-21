package com.mask.leetcode.middle;

import com.mask.leetcode.middle.bean.ListNode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class NumTwoTest {

    private NumTwo numTwo;

    @Before
    public void before() {
        numTwo = new NumTwo();
    }

    @Test
    public void addTwoNumbers() {
        ListNode listNode1 = new ListNode(5);
        // listNode1.next = numTwo.new ListNode(8);
        // listNode1.next.next = numTwo.new ListNode(3);
        // listNode1.next.next.next = numTwo.new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        // listNode2.next = numTwo.new ListNode(6);
        // listNode2.next.next = numTwo.new ListNode(4);
        // listNode2.next.next.next = numTwo.new ListNode(3);

        ListNode result = numTwo.addTwoNumbers(listNode1, listNode2);
        ListNode standard = numTwo.standard(listNode1, listNode2);

        numTwo.printListNode(result);
        numTwo.printListNode(standard);
    }
}