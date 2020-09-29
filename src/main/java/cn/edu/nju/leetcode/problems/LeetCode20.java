package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-13
 */
public class LeetCode20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isValid("()[]{}");
    }

    static class Solution {

        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            boolean match = true;
            int index = 0;

            while (match && index < s.length()) {
                char c = s.charAt(index);
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        match = !stack.isEmpty() && stack.pop() == '(';
                        break;
                    case '}':
                        match = !stack.isEmpty() && stack.pop() == '{';
                        break;
                    case ']':
                        match = !stack.isEmpty() && stack.pop() == '[';
                        break;
                    default:
                        return false;
                }
                index++;
            }

            return match && stack.isEmpty();
        }
    }
}
