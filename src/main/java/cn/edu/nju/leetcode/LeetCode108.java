package cn.edu.nju.leetcode;

import cn.edu.nju.leetcode.structure.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/12
 */
public class LeetCode108 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    /**
     * 给定的有序数组，将这个数组看作树的中序遍历的结果
     * 每次将中间点作为根节点进行递归构建高度平衡的 BST
     */
    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0, nums.length - 1);
        }

        private TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right) return null;
            if (left == right) return new TreeNode(nums[left]);
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, left, mid - 1);
            root.right = buildBST(nums, mid + 1, right);
            return root;
        }
    }
}
