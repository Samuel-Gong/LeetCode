package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode887 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superEggDrop(3, 26));
    }

    static class Solution {
        public int superEggDrop(int K, int N) {
            // dp[i][j] 表示 i 个鸡蛋，j 层楼，最坏情况下的最小移动次数
            int[][] dp = new int[K + 1][N + 1];
            // 初始条件，1 个鸡蛋，只能是线性搜索
            for (int i = 0; i < N + 1; i++) {
                dp[1][i] = i;
            }
            for (int i = 2; i < K + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    int min = j;
                    // dp[i][j] 的状态转移可以看作，在 [1, j] 之间找一层楼 k，分为鸡蛋碎与不碎两种情况
                    // 碎：鸡蛋数量少 1，楼层范围表示缩小为 [1, k-1]，转换为计算 dp[i-1][k-1]
                    // 不碎：鸡蛋数量不变，楼层范围缩小为 [k+1, j]，转换为计算 dp[i][j-k]
                    // 因为是选择最坏情况，所以是 max(碎, 不碎)

                    // 可以按照 [1, j] 线性搜索，计算每一层 k 求得 dp[i][j] 最小值
                    // for(int k = 1; k <= j; k++) {
                    //     min = Math.min(min, Math.max(dp[i][j-k], dp[i-1][k-1]) + 1);
                    // }
                    // 由于 dp[i][j-k] 根据 k 单调递减，dp[i-1][k-1] 根据 k 单调递增，则两个值有一个交点，交点即是最小值
                    // 所以也可以通过二分法加速查找中间最小值
                    // https://leetcode-cn.com/problems/super-egg-drop/solution/ji-ben-dong-tai-gui-hua-jie-fa-by-labuladong/
                    int left = 1;
                    int right = j;
                    int mid;
                    while (left <= right) {
                        mid = left + (right - left) / 2;
                        int decrease = dp[i][j - mid];
                        int increase = dp[i - 1][mid - 1];
                        if (decrease > increase) {
                            left = mid + 1;
                            min = Math.min(min, decrease + 1);
                        } else if (decrease < increase) {
                            right = mid - 1;
                            min = Math.min(min, increase + 1);
                        } else {
                            min = Math.min(min, decrease + 1);
                            break;
                        }
                    }
                    dp[i][j] = min;
                }
            }
            return dp[K][N];
        }
    }
}
