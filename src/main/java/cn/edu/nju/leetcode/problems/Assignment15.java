package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-14
 */
public class Assignment15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return threeSum(nums, 0);
        }

        private List<List<Integer>> threeSum(int[] nums, int target) {
            Arrays.sort(nums);

            int len = nums.length;

            List<List<Integer>> triples = new ArrayList<>();

            if (len < 3) {
                return triples;
            }

            for (int i = 0; i < nums.length && len - i >= 3; i++) {
                // 去重
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] > target) {
                    break;
                }
                int l = i + 1;
                int r = len - 1;
                if (nums[i] + nums[l] > target) {
                    break;
                }
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (nums[i] + nums[l] > target) {
                        break;
                    } else if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[i]);
                        triple.add(nums[l]);
                        triple.add(nums[r]);
                        triples.add(triple);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
            return triples;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }
}