package cn.edu.nju.leetcode.contest.contest_157;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment1 {
    static class Solution {
        public int minCostToMoveChips(int[] chips) {
            int odd = 0;
            int even = 0;
            for (int i = 0; i < chips.length; i++) {
                if (chips[i] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            return Math.min(odd, even);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.minCostToMoveChips(new int[]{1, 2, 3}));
//        System.out.println(solution.minCostToMoveChips(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}));
//        System.out.println(solution.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
//        System.out.println(solution.minCostToMoveChips(new int[]{1, 2, 2, 2, 2}));
        System.out.println(solution.minCostToMoveChips(new int[]{6, 4, 7, 8, 2, 10, 2, 7, 9, 7}));
    }
}
