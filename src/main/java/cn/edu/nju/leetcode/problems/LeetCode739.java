package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/6/11
 */
public class LeetCode739 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    /**
     * 单增栈，栈中存储的是数组索引
     */
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    int pre = stack.pop();
                    res[pre] = i - pre;
                }
                stack.push(i);
            }
            return res;
        }
    }
}
