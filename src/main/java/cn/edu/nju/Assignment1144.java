package cn.edu.nju;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/19
 * <p>
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * <p>
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrease-elements-to-make-array-zigzag
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Assignment1144 {

    static class Solution {
        public int movesToMakeZigzag(int[] nums) {

            int highLow = 0;

            int lowHigh = 0;
            int preLow = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (i % 2 != 0) {
                    // 高低高
                    int lower = nums[i - 1];
                    if (i < nums.length - 1) {
                        lower = Math.min(nums[i - 1], nums[i + 1]);
                    }
                    highLow += nums[i] < lower ? 0 : nums[i] - lower + 1;

                    // 低高低
                    lowHigh += nums[i] > preLow ? 0 : preLow - nums[i] + 1;
                    if (i < nums.length - 1) {
                        int diff = nums[i] > nums[i + 1] ? 0 : nums[i + 1] - nums[i] + 1;
                        lowHigh += diff;
                        preLow = nums[i+1] - diff;
                    }
                }
            }

            return Math.min(lowHigh, highLow);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movesToMakeZigzag(new int[]{1,2,3}));
    }

}
