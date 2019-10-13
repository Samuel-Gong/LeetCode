package cn.edu.nju.leetcode.contest;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/24
 */
public class Assignment1 {
    class Solution {
        public int game(int[] guess, int[] answer) {
            int res = 0;
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == answer[i]) {
                    res++;
                }
            }
            return res;
        }
    }
}
