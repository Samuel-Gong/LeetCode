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
public class LeetCode42 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 双指针法
     */
    static class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;
            int sum = 0;
            // 表示 [0, left) 的最大值，不包括 left 指针指向的位置
            int leftMax = 0;
            // 表示 (right, len-1] 的最大值，不包括 right 指针指向的位置
            int rightMax = 0;
            int left = 0;
            int right = height.length - 1;
            while (left <= right) {
                // leftMax < rightMax 时，表示此时 left 指针所指位置能接的雨水将由 leftMax 决定
                if (leftMax < rightMax) {
                    // leftMax 可能比 left 小，则 left 处不能接雨水
                    sum += Math.max(0, leftMax - height[left]);
                    leftMax = Math.max(height[left], leftMax);
                    left++;
                } else {
                    sum += Math.max(0, rightMax - height[right]);
                    rightMax = Math.max(height[right], rightMax);
                    right--;
                }
            }
            return sum;
        }
    }

    /**
     * 单增栈
     */
    static class Solution1 {
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;
            Deque<Integer> stack = new ArrayDeque<>();
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // height[i] 是在 height[stack.pop()] 右边第一个比 height[stack.pop()] 高的墙
                    int h = height[stack.pop()];
                    // 栈空表示 height[stack.pop()] 左边没有墙，不能计算距离
                    if (stack.isEmpty()) {
                        break;
                    }
                    // 计算 height[stack.pop()] 的左右两堵墙之间的距离
                    int distance = i - stack.peek() - 1;
                    // 找左右两堵墙中较矮的一堵
                    int min = Math.min(height[stack.peek()], height[i]);
                    // distance * (min-h) 表示两堵墙之间，h 之上的平面的雨水
                    sum = sum + distance * (min - h);
                }
                stack.push(i);
            }
            return sum;
        }
    }

}
