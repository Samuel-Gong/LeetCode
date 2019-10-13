package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/28
 */
public class Assignment394 {
    /**
     * 递归写法
     */
    static class Solution {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            Pair p;
            char c;
            while (i < s.length()) {
                c = s.charAt(i);
                if ('0' <= c && '9' >= c) {
                    p = innerString(s, i);
                    i = p.end + 1;
                    sb.append(p.str);
                } else {
                    sb.append(c);
                    i++;
                }
            }
            return sb.toString();
        }

        private Pair innerString(String s, int numStart) {
            StringBuilder sb = new StringBuilder();
            int i = numStart;
            int cur = 0;
            char c = s.charAt(i);
            while ('0' <= c && '9' >= c) {
                cur = cur * 10 + c - '0';
                i++;
                c = s.charAt(i);
            }
            int bracket = 1;
            i++;
            StringBuilder str = new StringBuilder();
            while (bracket > 0) {
                c = s.charAt(i);
                if (c == ']') {
                    bracket--;
                } else if ('0' > c || '9' < c) {
                    str.append(c);
                    i++;
                } else {
                    Pair pair = innerString(s, i);
                    i = pair.end + 1;
                    str.append(pair.str);
                }
            }
            for (int j = 0; j < cur; j++) {
                sb.append(str);
            }
            return new Pair(i, sb);
        }

        class Pair {
            int end;
            StringBuilder str;

            Pair(int e, StringBuilder s) {
                end = e;
                str = s;
            }
        }
    }

    /**
     * 非递归写法
     */
    static class Solution2 {
        public String decodeString(String s) {
            Deque<StringBuilder> deque = new ArrayDeque<>();
            Deque<Integer> repeat = new ArrayDeque<>();

            StringBuilder res = new StringBuilder();

            char c;
            int i = 0;
            while (i < s.length()) {
                c = s.charAt(i);
                if (c == ']') {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder cur = deque.pop();
                    int nums = repeat.pop();
                    for (int j = 0; j < nums; j++) {
                        sb.append(cur);
                    }
                    if (repeat.isEmpty()) {
                        res.append(sb);
                    } else {
                        deque.push(deque.pop().append(sb));
                    }
                    i++;
                } else if ('0' <= c && '9' >= c) {
                    int num = 0;
                    while ('0' <= c && '9' >= c) {
                        num = num * 10 + c - '0';
                        i++;
                        c = s.charAt(i);
                    }
                    repeat.push(num);
                    i++;
                    c = s.charAt(i);
                    StringBuilder sb = new StringBuilder();
                    while (('0' > c || '9' < c)) {
                        sb.append(c);
                        i++;
                        c = s.charAt(i);
                        if (c == ']') {
                            break;
                        }
                    }
                    deque.push(sb);
                } else {
                    if (deque.isEmpty()) {
                        res.append(c);
                    } else {
                        deque.push(deque.pop().append(c));
                    }
                    i++;
                }
            }

            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.decodeString("3[a2[c]]"));
        System.out.println(solution2.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution2.decodeString("3[a]2[b4[F]c]"));
    }
}
