package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/13
 */
public class LeetCode24 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.swapPairs(ListNode.fromArray(new int[]{1})));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            ListNode first, second;
            while (cur.next != null && cur.next.next != null) {
                first = cur.next;
                second = cur.next.next;
                cur.next = second;
                first.next = second.next;
                second.next = first;
                cur = first;
            }
            return dummy.next;
        }
    }
}
