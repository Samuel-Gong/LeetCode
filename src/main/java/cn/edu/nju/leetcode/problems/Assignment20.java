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
public class Assignment20 {

    class Solution {

        private Deque<Character> stack = new ArrayDeque<>();

        public boolean isValid(String s) {

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
                }
                index++;
            }

            return match && stack.isEmpty();
        }
    }

}
