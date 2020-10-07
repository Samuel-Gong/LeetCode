package cn.edu.nju.leetcode;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode75 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = new int[]{2, 0, 1};
        solution.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 典型的荷兰国旗问题，使用三个指针
     * left 指针指向左边第一个不为 0 的数
     * right 指针指向右边第一个不为 2 的数
     * cur 指针进行遍历，
     * if nums[cur] == 1, cur++
     * if nums[cur] == 0, 与 nums[left] 交换，交换前 nums[left] 必然为 1
     * 所以交换后，nums[left] == 0，nums[cur] == 1，此时应将 left++, cur++
     * if nums[cur] == 2, 与 nums[right] 交换，交换前，不知道 nums[right] 的值是多少
     * 所以交换后，nums[right] == 2, 需要 right--, 但是 cur 不变，下一次循环需要再次比较 cur 的数值
     */
    static class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int cur;
            while (left < right && nums[left] == 0) left++;
            while (right > left && nums[right] == 2) right--;
            cur = left;
            while (cur <= right) {
                if (nums[cur] == 2) {
                    swap(nums, cur, right);
                    right--;
                } else if (nums[cur] == 0) {
                    swap(nums, cur, left);
                    left++;
                    cur++;
                } else {
                    cur++;
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
