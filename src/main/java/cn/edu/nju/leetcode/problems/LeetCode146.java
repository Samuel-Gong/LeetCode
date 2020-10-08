package cn.edu.nju.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/8
 */
public class LeetCode146 {
    static class Solution {
        private class LRUCache {
            private class DLinkedNode {
                int key;
                int value;
                DLinkedNode prev;
                DLinkedNode next;

                DLinkedNode() {
                }

                DLinkedNode(int key, int value) {
                    this.key = key;
                    this.value = value;
                }
            }

            private Map<Integer, DLinkedNode> cache = new HashMap<>();
            private int size;
            private int capacity;
            private DLinkedNode head, tail;

            public LRUCache(int capacity) {
                this.size = 0;
                this.capacity = capacity;
                // 使用伪头部和伪尾部节点
                head = new DLinkedNode();
                tail = new DLinkedNode();
                head.next = tail;
                tail.prev = head;
            }

            public int get(int key) {
                // 检查 key
                DLinkedNode node = cache.get(key);
                if (node == null) {
                    return -1;
                }
                // 如果 key 存在，先通过哈希表定位，再移到头部
                moveToHead(node);
                return node.value;
            }

            public void put(int key, int value) {
                DLinkedNode node = cache.get(key);
                if (node == null) {
                    // 容量已满，删除双向链表的尾部节点
                    if (size == capacity) {
                        DLinkedNode tail = removeTail();
                        // 删除哈希表中对应的项
                        cache.remove(tail.key);
                        --size;
                    }
                    // 如果 key 不存在，创建一个新的节点
                    DLinkedNode newNode = new DLinkedNode(key, value);
                    // 添加进哈希表
                    cache.put(key, newNode);
                    // 添加至双向链表的头部
                    addToHead(newNode);
                    ++size;
                } else {
                    // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                    node.value = value;
                    moveToHead(node);
                }
            }

            // 添加到头部
            private void addToHead(DLinkedNode node) {
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            }

            // 删除某个节点
            private void removeNode(DLinkedNode node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            // 将某个节点移动到头部
            private void moveToHead(DLinkedNode node) {
                removeNode(node);
                addToHead(node);
            }

            // 删除尾部节点
            private DLinkedNode removeTail() {
                DLinkedNode res = tail.prev;
                removeNode(res);
                return res;
            }
        }
    }
}
