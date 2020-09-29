package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/9/29
 */
public class LeetCode14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }


    /**
     * 构造前缀树来解决
     */
    static class Solution {
        class Trie {
            private class Node {
                private static final int N = 26;
                Node[] children = new Node[N];
                boolean isWord = false;
                int count = 0;
            }

            private Node root = new Node();

            private void insert(String word) {
                char c;
                int index;
                Node cur = root;
                for (int i = 0; i < word.length(); i++) {
                    c = word.charAt(i);
                    index = c - 'a';
                    if (cur.children[index] == null) cur.children[index] = new Node();
                    cur.count++;
                    cur = cur.children[index];
                }
                // 到达单词最后一个字母
                cur.count++;
                cur.isWord = true;
            }

            // root.count 表示单词总数
            // node.count == root.count 则表示该结点在最长前缀中
            private String LCP() {
                Node cur = root;
                StringBuilder sb = new StringBuilder();
                while (true) {
                    boolean hasNext = false;
                    for (int i = 0; i < Node.N; i++) {
                        if (cur.children[i] != null && cur.children[i].count == root.count) {
                            hasNext = true;
                            cur = cur.children[i];
                            sb.append((char) ('a' + i));
                            break;
                        }
                    }
                    if (hasNext) continue;
                    break;
                }
                return sb.toString();
            }
        }

        public String longestCommonPrefix(String[] strs) {
            Trie trie = new Trie();
            for (int i = 0; i < strs.length; i++) {
                trie.insert(strs[i]);
            }
            return trie.LCP();
        }
    }

    /**
     * 纵向遍历，选定第一个 String
     * 外层循环为遍历第一个 String 的每一个 char，每次对比同一列的 char
     * 内层循环为遍历 String 数组
     * <p>
     * 时间复杂度：O(n*m)，n 表示字符串平均长度，m 表示字符串个数，最长公共前缀可能很短，所以循环可能很快结束，比横向遍历要快
     * 空间复杂度：O(1)
     */
    static class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            StringBuilder sb = new StringBuilder();
            char c;
            for (int i = 0; i < strs[0].length(); i++) {
                c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || c != strs[j].charAt(i)) return sb.toString();
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }


    /**
     * 采用分治的方法
     */
    static class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            return divide(strs, 0, strs.length - 1);
        }

        public String divide(String[] strs, int start, int end) {
            if (start == end) return strs[start];
            int mid = start + (end - start) / 2;
            String left = divide(strs, start, mid);
            String right = divide(strs, mid + 1, end);
            return longestCommonPrefixOfTwoString(left, right);
        }

        public String longestCommonPrefixOfTwoString(String s1, String s2) {
            if (s1.length() == 0 || s2.length() == 0) return "";
            StringBuilder sb = new StringBuilder();
            char c;
            for (int i = 0; i < s1.length(); i++) {
                c = s1.charAt(i);
                if (i >= s2.length() || c != s2.charAt(i)) return sb.toString();
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
