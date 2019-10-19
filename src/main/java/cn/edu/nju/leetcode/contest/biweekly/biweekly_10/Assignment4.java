package cn.edu.nju.leetcode.contest.biweekly.biweekly_10;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/5
 */
public class Assignment4 {
    static class Solution {
        public boolean isValidPalindrome(String s, int k) {
            int i = 0, j = s.length() - 1;
            char front, end;
            while (i < j && k >= 0) {
                front = s.charAt(i);
                end = s.charAt(j);
                if (front == end) {
                    i++;
                    j--;
                } else {
                    String tmp = s.substring(i, j + 1);
                    int next1 = tmp.lastIndexOf(front);
                    if (next1 == -1) {
                        i++;
                        k--;
                        continue;
                    }
                    int next2 = tmp.indexOf(end);
                    if (next2 == -1) {
                        j--;
                        k--;
                        continue;
                    }
                    if (isPalindrome(tmp.substring(1))) {
                        i++;
                        k--;
                        continue;
                    } else if (isPalindrome(tmp.substring(0, tmp.length() - 1))) {
                        j--;
                        k--;
                        continue;
                    }
                    int diff1 = j - next1 - i;
                    int diff2 = next2;
                    if (diff1 <= diff2) {
                        j -= (diff1 + 1);
                        i++;
                        k -= diff1;
                    } else {
                        i += (diff2 + 1);
                        j--;
                        k -= diff2;
                    }
                }
            }
            if (k < 0) {
                return false;
            }
            return true;
        }

        private boolean isPalindrome(String substring) {
            int i = 0, j = substring.length() - 1;
            while (i < j) {
                if (substring.charAt(i++) != substring.charAt(j--)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidPalindrome("abcdeca", 2));
        System.out.println(solution.isValidPalindrome("abbababa", 1));
        System.out.println(solution.isValidPalindrome("aaabaabaa", 1));
        System.out.println(solution.isValidPalindrome("bacabaaa", 2));
    }
}
