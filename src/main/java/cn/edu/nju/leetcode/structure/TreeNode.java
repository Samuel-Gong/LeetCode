package cn.edu.nju.leetcode.structure;

import java.util.ArrayList;
import java.util.List;

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

    public static TreeNode ofArray(Integer[] arr) {
        List<TreeNode> nodes = new ArrayList<>(arr.length + 1);
        nodes.add(new TreeNode(0, null, null));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            TreeNode n = new TreeNode(arr[i]);
            nodes.add(n);
            TreeNode parent = nodes.get((i + 1) / 2);
            if ((i + 1) % 2 == 0) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
        return nodes.get(1);
    }
}
