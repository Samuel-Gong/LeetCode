package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/24
 */
public class LeetCode239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    /**
     * 单调队列
     */
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            // 构建一个从对头到队尾单减的队列
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] > deque.peekLast()) deque.pollLast();
                deque.offer(nums[i]);
            }
            for (int i = 0; i < res.length - 1; i++) {
                res[i] = deque.peek();
                // 窗口向右移动，窗口删除值为 nums[i]，窗口新增值为 nums[i+k]
                if (nums[i] == deque.peek()) deque.poll();
                // 保持队列单减
                while (!deque.isEmpty() && nums[i + k] > deque.peekLast()) deque.pollLast();
                deque.offer(nums[i + k]);
            }
            res[res.length - 1] = deque.peek();
            return res;
        }
    }
}
