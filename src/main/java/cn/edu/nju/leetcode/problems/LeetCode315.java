package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/14
 */
public class LeetCode315 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(solution.countSmaller(new int[]{1, 1, 1, 1}));
    }

    /**
     * 模仿计算逆序对的做法（归并排序） + 一个索引数组（存储当前索引对应的原数组索引，数组下标表示当前索引）
     */
    static class Solution {
        int[] cnt;
        // 索引数组
        int[] indexArr;
        int[] auxiliary;

        public List<Integer> countSmaller(int[] nums) {
            if (nums == null || nums.length == 0) return new ArrayList<>();
            cnt = new int[nums.length];
            indexArr = new int[nums.length];
            for (int i = 0; i < indexArr.length; i++) {
                indexArr[i] = i;
            }
            auxiliary = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return Arrays.stream(cnt).boxed().collect(Collectors.toList());
        }

        private void mergeSort(int[] nums, int low, int high) {
            if (low == high) {
                return;
            }
            int[] indexArrTmp = new int[high - low + 1];
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            System.arraycopy(nums, low, auxiliary, low, high - low + 1);
            int pt1 = low;
            int pt2 = mid + 1;
            for (int i = low; i <= high; i++) {
                if (pt1 <= mid && pt2 <= high) {
                    if (auxiliary[pt1] <= auxiliary[pt2]) {
                        nums[i] = auxiliary[pt1];
                        indexArrTmp[i - low] = indexArr[pt1];
                        cnt[indexArr[pt1]] += pt2 - (mid + 1);
                        pt1++;
                    } else {
                        nums[i] = auxiliary[pt2];
                        indexArrTmp[i - low] = indexArr[pt2];
                        pt2++;
                    }
                } else if (pt1 > mid) {
                    nums[i] = auxiliary[pt2];
                    indexArrTmp[i - low] = indexArr[pt2];
                    pt2++;
                } else {
                    nums[i] = auxiliary[pt1];
                    indexArrTmp[i - low] = indexArr[pt1];
                    cnt[indexArr[pt1]] += pt2 - (mid + 1);
                    pt1++;
                }
            }
            for (int i = 0; i < indexArrTmp.length; i++) {
                indexArr[i + low] = indexArrTmp[i];
            }
        }
    }
}
