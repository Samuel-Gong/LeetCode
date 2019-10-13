package cn.edu.nju.leetcode.contest;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/22
 */
public class Assignment5199 {
    static class Solution {
        int[] parent;
        int[] size;
        int count;

        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            int len = s.length();
            parent = new int[len];
            size = new int[len];
            count = len;
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (List<Integer> pair : pairs) {
                union(pair.get(0), pair.get(1));
            }

            Map<Integer, List<Integer>> components = new HashMap<>(count);
            for (int i = 0; i < len; i++) {
                if (components.containsKey(find(i))) {
                    components.get(find(i)).add(i);
                } else {
                    List<Integer> indices = new ArrayList<>();
                    indices.add(i);
                    components.put(find(i), indices);
                }
            }

            char[] res = new char[s.length()];
            for (Map.Entry<Integer, List<Integer>> entry : components.entrySet()) {
                List<Integer> indices = entry.getValue();
                char[] chars = new char[indices.size()];
                int j = 0;
                for (int i : indices) {
                    chars[j++] = s.charAt(i);
                }
                Arrays.sort(chars);
                j = 0;
                for (int i : indices) {
                    res[i] = chars[j++];
                }
            }

            return new String(res);
        }

        public int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }

            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(0, 3));
        lists.add(Arrays.asList(1, 2));
        lists.add(Arrays.asList(0, 2));
        System.out.println(solution.smallestStringWithSwaps("dcab", lists));
    }
}
