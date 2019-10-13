package cn.edu.nju.leetcode.problems;

import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author Shenmiu
 * @date 2019-08-14
 */
public class Assignment23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            StringBuilder sb = new StringBuilder(Integer.toString(1));
            PriorityQueue<IndexNode> indexPQ = new PriorityQueue<>();
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    indexPQ.add(new IndexNode(i, lists[i].val));
                    lists[i] = lists[i].next;
                }
            }

            IndexNode indexNode;
            ListNode root = null;
            ListNode curNode;
            if (!indexPQ.isEmpty()) {
                indexNode = indexPQ.poll();
                root = new ListNode(indexNode.val);
                curNode = lists[indexNode.index];
                if (curNode != null) {
                    indexPQ.add(new IndexNode(indexNode.index, curNode.val));
                    lists[indexNode.index] = curNode.next;
                }
            }
            ListNode cur = root;
            while (!indexPQ.isEmpty()) {
                indexNode = indexPQ.poll();
                cur.next = new ListNode(indexNode.val);
                cur = cur.next;
                curNode = lists[indexNode.index];
                if (curNode != null) {
                    indexPQ.add(new IndexNode(indexNode.index, curNode.val));
                    lists[indexNode.index] = curNode.next;
                }
            }
            return root;
        }

        class IndexNode implements Comparable<IndexNode> {
            private int index;
            private int val;

            public IndexNode(int index, int val) {
                this.index = index;
                this.val = val;
            }

            @Override
            public int compareTo(IndexNode o) {
                if (this.val < o.val) {
                    return -1;
                } else if (this.val == o.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode7 = new ListNode(2);

        solution.mergeKLists(new ListNode[]{listNode1, listNode4, listNode7});
    }

}
