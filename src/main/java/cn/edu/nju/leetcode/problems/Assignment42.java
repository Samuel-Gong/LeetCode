package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author Shenmiu
 * @date 2019-08-01
 */
public class Assignment42 {

    static class Solution {
        public int trap(int[] height) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(0);
            int max = 0;
            int res = 0;
            for (int i = 0; i < height.length; i++) {
                int cur = height[i];
                if (cur <= deque.peek()) {
                    deque.push(cur);
                } else {
                    int base = max > cur ? cur : max;
                    while (!deque.isEmpty()) {
                        int mid = deque.pop();
                        res += cur - mid;
                    }
                    max = cur;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
