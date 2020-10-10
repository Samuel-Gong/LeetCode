package cn.edu.nju.leetcode.problems;

import java.util.PriorityQueue;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/10
 */
public class LeetCode215 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(solution.findKthLargest(new int[]{2, 1}, 1));
    }

    /**
     * 快排变式
     */
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;
            while (true) {
                int pivot = nums[left];
                int p1 = left;
                int p2 = right;
                while (p1 < p2) {
                    // 右边指针先行动，则跳出循环时，p1 所对应的值必定 <= pivot
                    while (p1 < p2 && nums[p2] > pivot) p2--;
                    while (p1 < p2 && nums[p1] <= pivot) p1++;
                    swap(nums, p1, p2);
                }
                swap(nums, left, p1);
                if (p1 == nums.length - k) {
                    return pivot;
                } else if (p1 < nums.length - k) {
                    left = p1 + 1;
                } else {
                    right = p1 - 1;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * 求第 k 个最大值，维护 size 为 k 的最小堆
     * size > k 时就将堆顶的最小值
     */
    static class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o1 - o2));
            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
                if (pq.size() > k) pq.poll();
            }
            return pq.poll();
        }
    }
}
