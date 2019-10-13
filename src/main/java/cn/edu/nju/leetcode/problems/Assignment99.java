package cn.edu.nju.leetcode.problems;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-24
 */
public class Assignment99 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode minNode = new TreeNode(Integer.MIN_VALUE);
            TreeNode maxNode = new TreeNode(Integer.MAX_VALUE);
            minNode.right = root;
            maxNode.left = root;

            TreeNode parent = new TreeNode(-1);
            parent.left = root;
            parent.left = recoverTree(root, minNode, maxNode);
        }

        private TreeNode recoverTree(TreeNode node, TreeNode minNode, TreeNode maxNode) {
            if (node == null) {
                return null;
            }
            if (node.val <= minNode.val) {
                exch(node, minNode);
            } else if (node.val >= maxNode.val) {
                exch(node, maxNode);
            }
            node.left = recoverTree(node.left, minNode, node);
            node.right = recoverTree(node.right, node, maxNode);
            return node;
        }

        private void exch(TreeNode node, TreeNode cmp) {
            int t = node.val;
            node.val = cmp.val;
            cmp.val = t;
        }

    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);

        node1.right = node2;
        node2.left = node3;

        Solution solution = new Solution();
        solution.recoverTree(node1);

    }

}
