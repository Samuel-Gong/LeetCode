package cn.edu.nju.leetcode.contest.biweekly.biweekly_10;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/5
 */
public class Assignment3 {
    static class Solution {
        private static List<Integer> all = new ArrayList<>();

        static {
            Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Integer i;
            int mod;
            int limit = (int) (2 * Math.pow(10, 9));
            while (!deque.isEmpty() && deque.peekFirst() <= limit) {
                i = deque.poll();
                all.add(i);
                mod = i % 10;
                if (mod == 0) {
                    deque.add(i * 10 + mod + 1);
                } else if (mod == 9) {
                    deque.add(i * 10 + mod - 1);
                } else {
                    deque.add(i * 10 + mod - 1);
                    deque.add(i * 10 + mod + 1);
                }
            }
        }

        public List<Integer> countSteppingNumbers(int low, int high) {
            Collections.sort(all);
            int l = Collections.binarySearch(all, low);
            int h = Collections.binarySearch(all, high);
            l = l >= 0 ? l : -l - 1;
            h = h >= 0 ? h : -h - 1;
            if (l > h) {
                return new ArrayList<>();
            }
            h = Math.min(h, all.size());
            if (h != all.size() && all.get(h) == high) {
                h = h + 1;
            }
            List<Integer> res = new ArrayList<>(all.subList(l, h));
            if (low == 0) {
                res.add(0, 0);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSteppingNumbers(0, 21));
        System.out.println(solution.countSteppingNumbers(1713834549, 1800528026));
        System.out.println(solution.countSteppingNumbers(709852790, 1686392249));
        System.out.println(solution.countSteppingNumbers(10, 15));
        System.out.println(solution.countSteppingNumbers(0, 1000000000));
    }
}
