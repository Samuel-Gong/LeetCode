package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/12
 */
public class LeetCode962 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        System.out.println(solution.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    /**
     * 使用单调栈从左往右存储严格单调递减的 A[i] 的索引
     * 可以证明，最大宽度坡的坡底 i 一定存在于单调栈中
     * 再从右往左遍历，当 A[i] >= 栈顶（即当前坡底时），与当前最大坡度比较，弹出栈顶
     * https://leetcode-cn.com/problems/maximum-width-ramp/solution/java-dan-diao-zhan-er-fen-jie-fa-chang-shi-jie-shi/
     */
    static class Solution {
        public int maxWidthRamp(int[] A) {
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            for (int i = 1; i < A.length - 1; i++) {
                while (A[i] < A[stack.peek()]) stack.push(i);
            }
            for (int i = A.length - 1; i >= 1; i--) {
                while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                    res = Math.max(res, i - stack.pop());
                }
            }
            return res;
        }
    }
}
