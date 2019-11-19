package com.mask.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode第一题
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class NumOne {

    // 解决方案一，暴力解决法，两层for循环
    public int[] answerOne(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++ ) {
            result[0] = i;
            int r1 = answerOneHelper(nums[i], nums, 0, i, target);
            if(r1 > -1) {
                result[1] = r1;
                break;
            }
            r1 = answerOneHelper(nums[i], nums, i + 1, nums.length, target);
            if(r1 > -1) {
                result[1] = r1;
                break;
            }
        }

        return result;
    }

    private int answerOneHelper(int num, int[] nums, int left, int right, int target) {
        int index = -1;
        for (int i = left; i < right; i++ ) {
            if ((nums[i] + num) == target) {
                index = i;
            }
            if (index > -1) {
                return index;
            }
        }

        return index;
    }


    // 解决方案二，两遍哈希表
    public int[] answerTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    // 解决方案三，一边哈希表
    //在进行迭代并将元素插入到表中的同时，
    // 我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
    // 如果它存在，那我们已经找到了对应解，并立即将其返回。
    public int[] answerThree(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
