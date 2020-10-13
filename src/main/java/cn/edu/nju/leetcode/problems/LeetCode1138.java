package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/13
 */
public class LeetCode1138 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("leet"));
    }

    /**
     * 模拟行动轨迹即可
     */
    static class Solution {
        public String alphabetBoardPath(String target) {
            if (target == null || target.length() == 0) return "";
            StringBuilder sb = new StringBuilder();
            int col = 5;
            int curX = 0;
            int curY = 0;
            char c;
            for (int i = 0; i < target.length(); i++) {
                c = target.charAt(i);
                int cx = (c - 'a') / 5;
                int cy = c - (cx * col + 'a');
                // 对 z 特殊处理
                if (cx == 5 && cy == 0) {
                    while (curY != 0) {
                        sb.append('L');
                        curY--;
                    }
                    while (curX < cx) {
                        sb.append('D');
                        curX++;
                    }
                } else {
                    while (curX != cx) {
                        if (curX > cx) {
                            sb.append('U');
                            curX--;
                        } else if (curX < cx) {
                            sb.append('D');
                            curX++;
                        }
                    }
                    while (curY != cy) {
                        if (curY > cy) {
                            sb.append('L');
                            curY--;
                        } else if (curY < cy) {
                            sb.append('R');
                            curY++;
                        }
                    }
                }
                sb.append('!');
            }
            return sb.toString();
        }
    }
}
