package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-14
 */
public class Assignment206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode first = head;
            ListNode reverse = null;
            while (first != null) {
                ListNode second = first.next;
                first.next = reverse;
                reverse = first;
                first = second;
            }
            return reverse;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        Solution solution = new Solution();
        solution.reverseList(one);
    }

}
