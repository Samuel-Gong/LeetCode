package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/19
 */
public class LeetCode809 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(solution.expressiveWords("abcd", new String[]{"abc"}));
        System.out.println(solution.expressiveWords("aaa", new String[]{"aaaa"}));
    }

    static class Solution {

        public int expressiveWords(String S, String[] words) {
            if (S.length() == 0 || words.length == 0) return 0;
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if (stretchy(S, words[i])) res++;
            }
            return res;
        }

        private boolean stretchy(String S, String word) {
            if (word.length() == 0) return false;
            int pt1 = 0;
            int pt2 = 0;
            char c1, c2;
            int cnt1 = 0, cnt2 = 0;
            while (pt1 < S.length() && pt2 < word.length()) {
                c1 = S.charAt(pt1);
                c2 = word.charAt(pt2);
                cnt1 = 0;
                cnt2 = 0;
                if (c1 != c2) return false;
                while (pt1 < S.length() && S.charAt(pt1) == c1) {
                    pt1++;
                    cnt1++;
                }
                while (pt2 < word.length() && word.charAt(pt2) == c2) {
                    pt2++;
                    cnt2++;
                }
                if (cnt1 == cnt2 || (cnt1 > cnt2 && cnt1 > 2)) continue;
                else return false;
            }
            return pt1 == S.length() && pt2 == word.length();
        }
    }
}
