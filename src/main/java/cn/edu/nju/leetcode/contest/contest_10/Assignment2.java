package cn.edu.nju.leetcode.contest.contest_10;

import cn.edu.nju.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/5
 */
public class Assignment2 {
    class Solution {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            pre(root1, l1);
            pre(root2, l2);
            for (Integer i : l1) {
                if (Collections.binarySearch(l2, target - i) > 0) {
                    return true;
                }
            }
            return false;
        }

        void pre(TreeNode root, List<Integer> l) {
            if (root == null) {
                return;
            }
            pre(root.left, l);
            l.add(root.val);
            pre(root.right, l);
        }
    }
}
