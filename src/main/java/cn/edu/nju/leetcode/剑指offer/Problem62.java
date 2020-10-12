package cn.edu.nju.leetcode.剑指offer;

/**
 * 0,1,,n-1 这 n 个数字排成一个圆圈，从数字 0 开始，每次从这个圆圈里删除第 m 个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4 这 5 个数字组成一个圆圈，从数字 0 开始每次删除第 3 个数字，则删除的前 4 个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/12
 */
public class Problem62 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lastRemaining(5, 3);
        solution.lastRemaining(10, 17);
    }

    /**
     * 由题意可知，最后一个数字在圆圈中的 index 为 0
     * 由该答案向前反推
     * 最后一轮的时候，该数字在圆圈中的 index 为 (0+m) % 2
     *
     * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     */
    static class Solution {
        public int lastRemaining(int n, int m) {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = (res + m) % i;
            }
            return res;
        }
    }
}
