package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/3
 */
public class Assignment1035 {
    static class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int res = 0;
            int prej = -1;
            boolean[] occupied = new boolean[B.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i] == B[j]) {
                        if (j > prej) {
                            res++;
                            occupied[prej] = false;
                            prej = j;
                            occupied[prej] = true;
                            break;
                        } else if (j < prej && !occupied[j]) {
                            occupied[prej] = false;
                            prej = j;
                            occupied[prej] = true;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(solution.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
//        System.out.println(solution.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
//        System.out.println(solution.maxUncrossedLines(new int[]{3, 2, 2, 3}, new int[]{1, 1, 2, 3, 2}));
//        System.out.println(solution.maxUncrossedLines(new int[]{1, 1, 2, 1, 2}, new int[]{1, 3, 2, 3, 1}));

    }
}
