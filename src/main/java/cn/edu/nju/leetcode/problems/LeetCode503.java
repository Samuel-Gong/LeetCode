package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/10
 */
public class LeetCode503 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, -1})));
    }

    /**
     * 单增栈
     * 初始化结果数组为 -1，从左往右遍历，栈中存储的数组的索引
     * 因为是循环数组，遍历两倍数组长度即可
     */
    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            for (int i = 0; i < nums.length * 2; i++) {
                while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[i % nums.length];
                }
                stack.push(i % nums.length);
            }
            return res;
        }
    }
}
