package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/30
 */
public class Assignment1130 {

    static class Solution {
        public int mctFromLeafValues(int[] arr) {
            int res = 0;
            Deque<Integer> d = new ArrayDeque<>();
            d.push(Integer.MAX_VALUE);
            for (int a : arr) {
                while (d.peek() <= a) {
                    int mid = d.pop();
                    res += mid * Math.min(d.peek(), a);
                }
                d.push(a);
            }
            while (d.size() > 2) {
                res += d.pop() * d.peek();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{6, 2, 4}));
    }
}
