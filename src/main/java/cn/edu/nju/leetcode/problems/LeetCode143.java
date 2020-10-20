package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/20
 */
public class LeetCode143 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4});
        solution.reorderList(head);
        System.out.println(head);
    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 后一半
            ListNode pt2 = reverse(slow.next);
            // 从中间断开
            slow.next = null;
            ListNode pt1 = head;
            ListNode pt1Next, pt2Next;
            while (pt2.next != null) {
                pt1Next = pt1.next;
                pt2Next = pt2.next;
                pt1.next = pt2;
                pt2.next = pt1Next;
                pt1 = pt1Next;
                pt2 = pt2Next;
            }
            pt1Next = pt1.next;
            pt1.next = pt2;
            pt2.next = pt1Next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode tmpNext;
            while (cur != null) {
                tmpNext = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmpNext;
            }
            return pre;
        }
    }
}
