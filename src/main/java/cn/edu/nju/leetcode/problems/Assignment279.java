package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment279 {
    static class Solution {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 1, 2, 3, 4, 2, 1, 2, 3, 3));

        public int numSquares(int n) {
            if (1 <= n && n <= 12) {
                return arr.get(n);
            }
            int base = 3;
            for (int i = 13; i <= n; i++) {
                if (i == (base + 1) * (base + 1)) {
                    arr.add(0);
                    base++;
                } else {
                    arr.add(n - base * base);
                }
            }
            int res = 0;
            int i = n;
            while (i > 12) {
                res++;
                i = arr.get(i);
            }
            return res + arr.get(i);
        }
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.numSquares(18));
    }
}
