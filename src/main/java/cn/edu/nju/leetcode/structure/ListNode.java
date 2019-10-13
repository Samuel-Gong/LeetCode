package cn.edu.nju.leetcode.structure;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/20
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode constructLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode cur = this; cur != null; cur = cur.next) {
            sb.append(cur.val).append(" -> ");
        }
        sb.append("NULL");
        return sb.toString();
    }
}
