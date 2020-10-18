package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/6/8
 */
public class LeetCode990 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
    }


    /**
     * 并查集
     */
    static class Solution {
        int[] parents = new int[26];

        public boolean equationsPossible(String[] equations) {
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < equations.length; i++) {
                char p = equations[i].charAt(0);
                char q = equations[i].charAt(3);
                if (equations[i].charAt(1) == '=') {
                    if (p == q) continue;
                    int rootP = find(p - 'a');
                    int rootQ = find(q - 'a');
                    parents[rootQ] = rootP;
                } else {
                    if (p == q) return false;
                }
            }
            for (int i = 0; i < equations.length; i++) {
                if (equations[i].charAt(1) == '!') {
                    char p = equations[i].charAt(0);
                    char q = equations[i].charAt(3);
                    if (p != q) {
                        if (find(p - 'a') == find(q - 'a')) return false;
                    }
                }
            }
            return true;
        }

        private int find(int p) {
            while (parents[p] != p) {
                p = parents[p];
            }
            return p;
        }
    }
}
