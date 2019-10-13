package cn.edu.nju.leetcode.problems;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/3
 */
public class Assignment986 {
    static class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int i = 0, j = 0;
            int al, ar, bl, br, il, ir;
            List<int[]> res = new ArrayList<>();
            while (i < A.length && j < B.length) {
                al = A[i][0];
                ar = A[i][1];
                bl = B[j][0];
                br = B[j][1];
                if (al <= br && bl <= ar) {
                    il = Math.max(al, bl);
                    if (ar > br) {
                        ir = br;
                        res.add(new int[]{il, ir});
                        j++;
                    } else if (br > ar) {
                        ir = ar;
                        res.add(new int[]{il, ir});
                        i++;
                    } else {
                        res.add(new int[]{il, ar});
                        i++;
                        j++;
                    }
                } else if (al > br) {
                    j++;
                } else {
                    i++;
                }
            }
            int[][] arr = new int[res.size()][2];
            for (int k = 0; k < arr.length; k++) {
                arr[k] = res.get(k);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }
}
