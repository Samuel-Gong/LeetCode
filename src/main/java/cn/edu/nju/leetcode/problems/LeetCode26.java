package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/29
 */
public class LeetCode26 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    /**
     * 利用快慢指针
     * 慢指针 i 指向当前非重复数组的最后一个数
     * 快指针 j 指向当前遍历的位置
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
