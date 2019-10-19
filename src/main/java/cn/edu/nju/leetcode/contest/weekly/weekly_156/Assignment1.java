package cn.edu.nju.leetcode.contest.weekly.weekly_156;

import java.util.HashMap;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment1 {
    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            int[] nums = new int[2001];
            for (int i : arr) {
                nums[i + 1000]++;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (map.get(nums[i]) != null) {
                        return false;
                    }
                    map.put(nums[i], i - 1000);
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }
}
