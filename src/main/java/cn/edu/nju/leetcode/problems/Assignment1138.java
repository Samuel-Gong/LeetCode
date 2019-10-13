package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/11
 */
public class Assignment1138 {
    static class Solution {
        public String alphabetBoardPath(String target) {
            int cur = 0;
            int c;
            int diff;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < target.length()) {
                c = target.charAt(i) - 'a';
                diff = cur - c;
                if (diff == 0) {
                    sb.append('!');
                    i++;
                } else if (diff > 0) {
                    if (c / 5 == cur / 5) {
                        sb.append('L');
                        cur--;
                    } else {
                        sb.append('U');
                        cur = cur - 5;
                    }
                } else {
                    if (c / 5 == cur / 5) {
                        sb.append('R');
                        cur++;
                    } else if (cur + 5 > 25) {
                        sb.append('L');
                        cur--;
                    } else {
                        sb.append('D');
                        cur += 5;
                    }
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("leet"));
        System.out.println(solution.alphabetBoardPath("code"));
        System.out.println(solution.alphabetBoardPath("zdz"));
    }
}
