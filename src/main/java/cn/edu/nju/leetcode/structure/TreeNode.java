package cn.edu.nju.leetcode.structure;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/28
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * @param arr 形似完全二叉树的值的数组，中间为空的节点用 null 表示
     * @return 构造的树的根节点
     */
    public static TreeNode ofArray(Integer[] arr) {
        // 按照完全二叉树去构造一棵树
        TreeNode[] nodes = new TreeNode[arr.length + 1];
        // 生成一个假的父节点，循环内可以对所有节点进行一致处理
        nodes[0] = new TreeNode(0);
        for (int i = 1; i < nodes.length; i++) {
            if (arr[i - 1] == null) {
                continue;
            }
            nodes[i] = new TreeNode(arr[i - 1]);
            // 找到父节点
            TreeNode parent = nodes[i / 2];
            // 判断是左子节点还是右子节点
            if (i % 2 == 0) {
                parent.left = nodes[i];
            } else {
                parent.right = nodes[i];
            }
        }
        return nodes[1];
    }
}
