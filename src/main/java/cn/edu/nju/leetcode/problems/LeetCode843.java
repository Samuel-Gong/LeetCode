package cn.edu.nju.leetcode.problems;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/6
 */
public class LeetCode843 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}})));
    }

    /**
     * 树形 dp
     * 先选 0 作为根节点，计算 dp 和 sz
     * 再 dfs，切换根节点，
     */
    static class Solution {

        int[] res;
        int[] dp;
        // 表示子节点个数（包含本身）
        int[] sz;
        List<Set<Integer>> adj;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            res = new int[N];
            dp = new int[N];
            sz = new int[N];
            adj = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                adj.add(new HashSet<>());
            }
            for (int i = 0; i < N - 1; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            dfs(0, -1);
            dfs2(0, -1);
            return res;
        }

        public void dfs(int root, int parent) {
            sz[root] = 1;
            for (int child : adj.get(root)) {
                if (child != parent) {
                    dfs(child, root);
                    dp[root] += dp[child] + sz[child];
                    sz[root] += sz[child];
                }
            }
        }

        public void dfs2(int root, int parent) {
            // 当前 dp[root] 为到其它各节点距离之和
            res[root] = dp[root];
            for (int child : adj.get(root)) {
                if (child != parent) {
                    int preRootDp = dp[root], preChildDp = dp[child];
                    int preRootSize = sz[root], preChildSize = sz[child];

                    // 根节点由 root 切换为 child
                    // 当前根节点到其它节点距离之和转变为到子节点的距离之和
                    dp[root] -= (dp[child] + sz[child]);
                    // root 子节点个数需要移除 child 的子节点个数
                    sz[root] -= sz[child];
                    // child 子节点转换为根节点后，子节点个数更新加上 root 子节点个数
                    sz[child] += sz[root];
                    // 计算当前根节点 child 到其它节点的距离，原 dp[child] 表示除 root 子树以外子节点的距离，只需加上 root 子树
                    dp[child] += dp[root] + sz[root];

                    dfs2(child, root);

                    dp[root] = preRootDp;
                    dp[child] = preChildDp;
                    sz[root] = preRootSize;
                    sz[child] = preChildSize;
                }
            }
        }

    }
}
