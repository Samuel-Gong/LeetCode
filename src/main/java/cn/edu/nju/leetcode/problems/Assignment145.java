package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/28
 */
public class Assignment145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode lastPop = null;
            TreeNode curNode = root;
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            while (!stack.isEmpty()) {
                curNode = stack.peek();
                //一个根节点被访问的前提是：无右子树或右子树已被访问过
                if (curNode.right != null && curNode.right != lastPop) {
                    //修改最近被访问的节点
                    //进入右子树，且可肯定右子树一定不为空
                    curNode = curNode.right;
                    while (curNode != null) {
                        //再走到右子树的最左边
                        stack.push(curNode);
                        curNode = curNode.left;
                    }
                } else {
                    //访问
                    res.add(curNode.val);
                    //修改最近被访问的节点
                    lastPop = stack.pop();
                }

            }
            return res;
        }
    }
}
