package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-14
 */
public class Assignment203 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode cur = head;
            if (head == null) {
                return null;
            }
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode prev = cur;
            cur = cur.next;
            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                    cur = cur.next;
                    continue;
                }
                prev = prev.next;
                cur = cur.next;
            }
            return head;
        }
    }
}
