package cn.edu.nju.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/9
 */
public class Assignment1156 {
    static class Solution {
        public int maxRepOpt1(String text) {
            Map<Character, int[]> map = new HashMap<>();
            char c;
            int[] a;
            int start1, start2, end1, end2;
            int i = 0;
            while (i < text.length()) {
                c = text.charAt(i);
                a = map.get(c);
                if (a != null && i == a[2]) {
                    i = a[3];
                    continue;
                }
                start1 = i;
                end1 = i;
                while (end1 < text.length() && c == text.charAt(end1)) {
                    end1++;
                }
                int len = 0;
                if (a != null && start1 - 1 == a[3] && c == text.charAt(a[2])) {
                    if (a[0] != 0 && a[1] == 0) {
                        a[0]++;
                        a[1] = 1;
                    }
                    len = a[3] - a[2] + end1 - start1 + a[1];
                    a[2] = start1;
                    a[3] = end1;
                } else if (end1 + 1 < text.length() && c == text.charAt(end1 + 1)) {
                    start2 = end1 + 1;
                    end2 = end1 + 1;
                    while (end2 < text.length() && c == text.charAt(end2)) {
                        end2++;
                    }
                    if (a == null) {
                        a = new int[]{0, 0, 0, 0};
                    }
                    if (a[0] != 0 && a[1] == 0) {
                        a[0]++;
                        a[1] = 1;
                    }
                    len = end1 - start1 + end2 - start2 + a[1];
                    a[2] = start2;
                    a[3] = end2;
                } else {
                    if (a == null) {
                        a = new int[]{end1 - start1, 0, start1, end1};
                        map.put(c, a);
                    } else {
                        if (a[0] != 0 && a[1] == 0) {
                            a[0]++;
                            a[1] = 1;
                        }
                        len = end1 - start1 + a[1];
                    }
                    a[2] = start1;
                    a[3] = end1;
                }
                a[0] = Math.max(len, a[0]);
                map.put(c, a);
                i = end1;
            }

            int max = 0;
            for (
                    Map.Entry<Character, int[]> entry : map.entrySet()) {
                a = entry.getValue();
                max = Math.max(max, a[0]);
            }

            return max;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepOpt1("ababa"));
        System.out.println(solution.maxRepOpt1("aaabaaa"));
        System.out.println(solution.maxRepOpt1("aaabbaaa"));
        System.out.println(solution.maxRepOpt1("aaaaa"));
        System.out.println(solution.maxRepOpt1("abcdef"));
        System.out.println(solution.maxRepOpt1("aabaaabaaaba"));
        System.out.println(solution.maxRepOpt1("babbaaabbbbbaa"));
        System.out.println(solution.maxRepOpt1("baaabaaaaaaabaab"));
        System.out.println(solution.maxRepOpt1("abbabaabababaaabbaaa"));

    }
}
