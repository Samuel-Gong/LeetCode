package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/27
 */
public class Assignment991 {
    static class Solution {
        public int brokenCalc(int X, int Y) {
            if (X >= Y) {
                return X - Y;
            }
            int cnt = 0;
            if (Y % 2 != 0) {
                Y = Y + 1;
                cnt++;
            }
            if (Y >= X * 2) {
                while (Y > X && Y % 2 == 0) {
                    Y = Y / 2;
                    while (Y % 2 != 0 && Y > X) {
                        Y = Y + 1;
                        cnt++;
                    }
                    cnt++;
                }
            } else {
                while (Y > X && Y % 2 == 0) {
                    Y = Y / 2;
                    while (Y % 2 != 0 && Y > X) {
                        Y = Y + 1;
                        cnt++;
                    }
                    cnt++;
                }
            }
            cnt = cnt + X - Y;
            return cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().brokenCalc(363, 811));
    }
}
