package cn.edu.nju.leetcode.problems;

import cn.edu.nju.leetcode.structure.ListNode;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment328 {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int len = 0;
            for (ListNode cur = head; cur != null; cur = cur.next) {
                len++;
            }
            ListNode odd = head;
            for (int i = 0; i < len / 2; i++) {
                ListNode cur = odd;
                for (ListNode even = odd.next; even.next != null; ) {
                    ListNode tmp = even.next;
                    even.next = tmp.next;
                    tmp.next = even;
                    cur.next = tmp;
                    cur = cur.next;
                }
                odd = odd.next;
            }
            return head;
        }
    }

    class Solution2 {
        public ListNode oddEvenList(ListNode head) {
            if (head != null) {

                ListNode odd = head, even = head.next, evenHead = even;

                while (even != null && even.next != null) {
                    odd.next = odd.next.next;
                    even.next = even.next.next;
                    odd = odd.next;
                    even = even.next;
                }
                odd.next = evenHead;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructLinkedList(new int[]{2, 1, 3, 5, 6, 4, 7});
        Solution solution = new Solution();
        System.out.println(solution.oddEvenList(head));
    }
}
