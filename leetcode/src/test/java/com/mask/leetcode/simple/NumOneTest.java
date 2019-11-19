package com.mask.leetcode.simple;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumOneTest {

    private NumOne numOne;

    private int[] nums = {2, 7, 11, 15};

    private int target = 9;

    @Before
    public void before(){
        numOne = new NumOne();
    }

    @Test
    public void answerOne() {
        System.out.println("AnswerOne : " + JSON.toJSONString(numOne.answerOne(nums, target)));
    }

    @Test
    public void answerTwo() {
        System.out.println("AnswerTwo : " + JSON.toJSONString(numOne.answerTwo(nums, target)));
    }

    @Test
    public void answerThree() {
        System.out.println("AnswerThree : " + JSON.toJSONString(numOne.answerThree(nums, target)));
    }
}