package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * <p>
 *
 * @author Shenmiu
 * @date 2020/7/14
 */
public class LeetCode82 {
    public static void main(String[] args) {
        LeetCode82 solution = new LeetCode82();
        System.out.println(solution.deleteDuplicates(ListNode.fromArray(new int[]{1, 2, 3, 3, 4, 4, 5})));
        System.out.println(solution.deleteDuplicates(ListNode.fromArray(new int[]{1, 1, 1, 2, 3})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int rmval;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                rmval = cur.next.val;
                while (cur.next != null && cur.next.val == rmval) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
