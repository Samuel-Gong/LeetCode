package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/2
 */
public class Assignment904 {
    static class Solution {
        public int totalFruit(int[] tree) {
            if (tree.length == 1) {
                return tree.length;
            }
            int i = 0;
            int one = tree[0];
            int k = 1;
            while (k < tree.length && tree[k] == one) {
                k++;
            }
            if (k == tree.length) {
                return tree.length;
            }
            int another = tree[k];
            int max = k + 1;
            int pre = another;
            int preIndex = k;
            for (; k < tree.length; k++) {
                if (tree[k] != one && tree[k] != another) {
                    max = Math.max(max, k - i);
                    i = preIndex;
                    one = pre;
                    preIndex = k;
                    pre = tree[k];
                    another = tree[k];
                } else if (tree[k] != pre) {
                    pre = tree[k];
                    preIndex = k;
                }
            }

            max = Math.max(max, tree.length - i);

            return max;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(solution.totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(solution.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }
}
