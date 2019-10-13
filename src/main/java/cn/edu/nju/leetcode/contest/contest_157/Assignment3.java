package cn.edu.nju.leetcode.contest.contest_157;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment3 {
    static class Solution {
        public String removeDuplicates(String s, int k) {
            Deque<Character> cStack = new ArrayDeque<>();
            Deque<Integer> nStack = new ArrayDeque<>();
            char last = s.charAt(0);
            int repeat = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == last) {
                    repeat++;
                    if (repeat == k) {
                        if (!cStack.isEmpty() && cStack.peek() == chars[i]) {
                            cStack.pop();
                            nStack.pop();
                        }
                        repeat = 0;
                        if (!cStack.isEmpty() && !nStack.isEmpty()) {
                            last = cStack.peek();
                            repeat = nStack.peek();
                        }
                    }
                } else {
                    if (!cStack.isEmpty() && cStack.peek() == last) {
                        nStack.pop();
                        if (repeat < k) {
                            nStack.push(repeat);
                            repeat = 1;
                        }
                    } else {
                        cStack.push(last);
                        nStack.push(repeat);
                        repeat = 1;
                    }
                    last = chars[i];
                }
            }
            if (last == s.charAt(s.length() - 1)) {
                cStack.push(last);
                nStack.push(repeat);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : cStack) {
                int num = nStack.pop();
                for (int i = 0; i < num; i++) {
                    sb.insert(0, c);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
