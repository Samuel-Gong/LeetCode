//package cn.edu.nju.leetcode;
//
//import java.util.Arrays;
//
///**
// * <p>
// * <p>
// *
// * @author Shenmiu
// * @date 2019/10/11
// */
//public class Assignment300 {
//    static class Solution {
//        public int lengthOfLIS(int[] nums) {
//            if (nums.length == 0) {
//                return 0;
//            }
//            Arrays.binarySearch(nums, 0, 0, key);
//            int[] dp = new int[nums.length];
//            Arrays.fill(dp, 1);
//            int max = 1;
//            for (int i = 1; i < nums.length; i++) {
//                int cur = 1;
//                for (int j = 0; j < i; j++) {
//                    if (nums[i] > nums[j]) {
//                        cur = Math.max(cur, dp[j] + 1);
//                    }
//                }
//                dp[i] = cur;
//                max = Math.max(max, cur);
//            }
//            return max;
//        }
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//    }
//}
