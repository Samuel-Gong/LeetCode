package cn.edu.nju.leetcode.contest.weekly.weekly_156;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment2 {
    static class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int[] cost = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }

            int curLen = 0;
            int remainCost = maxCost;
            int p1 = 0;
            int max = 0;
            while (p1 < s.length()) {
                while (remainCost >= 0 && p1 + curLen < s.length()) {
                    remainCost -= cost[p1 + curLen];
                    curLen++;
                }
                if (remainCost >= 0) {
                    max = Math.max(max, curLen);
                    return max;
                } else if (curLen > 0) {
                    max = Math.max(max, curLen - 1);
                    remainCost += cost[p1];
                    curLen--;
                }
                p1++;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
    }
}
