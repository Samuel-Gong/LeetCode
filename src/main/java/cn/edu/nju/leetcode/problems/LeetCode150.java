package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class LeetCode150 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> token = new ArrayDeque<>();
            char c;
            int num1, num2;
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].length() > 1) {
                    token.push(Integer.parseInt(tokens[i]));
                    continue;
                }
                c = tokens[i].charAt(0);
                switch (c) {
                    case '+':
                        num2 = token.pop();
                        num1 = token.pop();
                        token.push(num1 + num2);
                        break;
                    case '-':
                        num2 = token.pop();
                        num1 = token.pop();
                        token.push(num1 - num2);
                        break;
                    case '*':
                        num2 = token.pop();
                        num1 = token.pop();
                        token.push(num1 * num2);
                        break;
                    case '/':
                        num2 = token.pop();
                        num1 = token.pop();
                        token.push(num1 / num2);
                        break;
                    default:
                        token.push(Integer.parseInt(tokens[i]));
                }
            }
            return token.pop();
        }
    }
}
