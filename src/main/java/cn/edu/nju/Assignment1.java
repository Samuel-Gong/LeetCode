package cn.edu.nju;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-15
 */
public class Assignment1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            int[] copy = new int[len];
            System.arraycopy(nums, 0, copy, 0, len);
            Arrays.sort(copy);
            int l = 0;
            int r = len - 1;
            while (l < r) {
                int sum = copy[l] + copy[r];
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    int indexL = 0;
                    int indexR = 0;
                    for (int i = 0; i < len; i++) {
                        if (nums[i] == copy[l]) {
                            indexL = i;
                            break;
                        }
                    }
                    for (int i = 0; i < len; i++) {
                        if (nums[i] == copy[r] && indexL != i) {
                            indexR = i;
                            break;
                        }
                    }
                    if (indexL > indexR) {
                        int temp = indexL;
                        indexL = indexR;
                        indexR = temp;
                    }
                    return new int[]{indexL, indexR};
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{3, 2, 3}, 6);
    }
}
