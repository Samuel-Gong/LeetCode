package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.Node;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/15
 */
public class LeetCode116 {
    /**
     * 注意利用已经构建好的 next 关系
     * 可以由当前层的 next 的关系，构建下一层的 next 关系，类似于层次遍历
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Node leftmost = root;
            while (leftmost.left != null) {
                Node cur = leftmost;
                while (cur != null) {
                    // connection 1
                    if (cur.left != null) cur.left.next = cur.right;
                    // connection 2
                    if (cur.next != null) cur.right.next = cur.next.left;
                    cur = cur.next;
                }
                leftmost = leftmost.left;
            }
            return root;
        }
    }
}
