package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/5/23
 */
public class LeetCode227 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2"));
        System.out.println(solution.calculate(" 3/2 "));
        System.out.println(solution.calculate(" 3+5 / 2 "));
    }

    /**
     * sign 和 num 配对，初始 sign 为 '+'，将计算结果压栈，最后计算栈中数字的和即可
     * https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/
     */
    static class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';
            char c;
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                // 处理数字
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                // 注意判断条件
                // 1. 需要处理空格
                // 2. 到达数组最后，需要处理最后一个数字
                if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || i == s.length() - 1) {
                    // 注意这里是 switch sign，而不是 c
                    switch (sign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                        default:
                            break;
                    }
                    // 更新符号，重置数字
                    sign = c;
                    num = 0;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }
}
