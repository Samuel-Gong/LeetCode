package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/5/17
 */
public class LeetCode25 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(solution.reverseKGroup(ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), 3));
    }

    /**
     * 迭代实现
     */
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            ListNode preTail = dummy;
            dummy.next = head;
            while (preTail != null) {
                ListNode curHead = preTail.next;
                ListNode cur = curHead;
                int cnt = 0;
                for (; cur != null && cnt < k; cnt++) {
                    cur = cur.next;
                }
                // [curHead, cur) 之间有 k 个节点
                if (cnt == k) {
                    preTail.next = reverse(curHead, cur);
                    preTail = curHead;
                    preTail.next = cur;
                } else {
                    preTail = cur;
                }
            }
            return dummy.next;
        }

        private static ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode nextTmp;
            while (cur != tail) {
                nextTmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextTmp;
            }
            return pre;
        }
    }

    /**
     * 递归实现
     */
    static class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) return null;
            // 开区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转，base case
                if (b == null) return head;
                b = b.next;
            }
            // 反转前 k 个元素
            ListNode newHead = reverse(a, b);
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);
            return newHead;
        }

        private static ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode cur = head;
            ListNode nextTmp;
            while (cur != tail) {
                nextTmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextTmp;
            }
            return pre;
        }
    }
}
