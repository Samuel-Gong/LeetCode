package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/7
 */
public class LeetCode234 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(ListNode.fromArray(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome(ListNode.fromArray(new int[]{1, 2, 1})));
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            // 若链表长度为奇数，则该节点为中间节点
            // 若链表长度为偶数，则该节点为中间左节点
            ListNode endOfFirstHalf = endOfFirstHalf(head);
            // 若链表长度为奇数，则该节点为中间节点的后一个节点
            // 若链表长度为偶数，则该节点为中间右节点
            ListNode headOfSecondHalf = endOfFirstHalf.next;

            ListNode reverseSecondHalf = reverseList(headOfSecondHalf);

            // 注意，需要将前一半与后一半断开
            endOfFirstHalf.next = null;

            // 由上可知，原链表长度为奇数时，len(p1) = len(p2) + 1
            // 原链表长度为偶数时，len(p1) = len(p2)
            // 所以只需要比较 p2 链表长度的数值即可
            ListNode p1 = head;
            ListNode p2 = reverseSecondHalf;
            System.out.println(p1);
            System.out.println(p2);
            // 故判断条件为 p2 不为 null
            while (p2 != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        ListNode endOfFirstHalf(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode nextTmp;
            while (cur != null) {
                nextTmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextTmp;
            }
            return prev;
        }
    }
}
