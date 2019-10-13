package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/12
 */
public class Assignment670 {
    static class Solution {
        public int maximumSwap(int num) {
            char[] chars = Integer.toString(num).toCharArray();
            int p = 0;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] < chars[i + 1]) {
                    p = i + 1;
                    break;
                }
            }
            int max_i = p;
            for (int i = p + 1; i < chars.length; i++) {
                max_i = chars[i] >= chars[max_i] ? i : max_i;
            }

            for (int i = 0; i < p; i++) {
                if (chars[i] < chars[max_i]) {
                    char c = chars[i];
                    chars[i] = chars[max_i];
                    chars[max_i] = c;
                    break;
                }
            }

            return Integer.parseInt(new String(chars));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
    }
}
