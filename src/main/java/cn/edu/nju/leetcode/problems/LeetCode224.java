package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/14
 */
public class LeetCode224 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1 + 1"));
        Solution solution2 = new Solution();
        System.out.println(solution2.calculate(" 2-1 + 2 "));
        Solution solution3 = new Solution();
        System.out.println(solution3.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    /**
     * 在 LeetCode227 的基础上，加入了对括号的处理
     * 使用递归对括号进行处理
     */
    static class Solution {

        int index = 0;

        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';
            int num = 0;
            char c;
            for (; index < s.length(); index++) {
                c = s.charAt(index);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }
                if (c == '(') {
                    index++;
                    num = calculate(s);
                }
                // 对于运算符, (, 以及到达数组末尾的情况，都要对数字进行处理
                if ((!Character.isDigit(c) && !Character.isWhitespace(c)) || index == s.length() - 1) {
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
                    sign = c;
                    num = 0;
                }
                if (c == ')') {
                    break;
                }
            }

            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }

        private boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
    }
}
