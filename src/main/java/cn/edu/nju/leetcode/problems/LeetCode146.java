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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回  1
        System.out.println(cache.get(1));
        // 该操作会使得关键字 2 作废
        cache.put(3, 3);
        // 返回 -1 (未找到)
        System.out.println(cache.get(2));
        // 该操作会使得关键字 1 作废
        cache.put(4, 4);
        // 返回 -1 (未找到)
        System.out.println(cache.get(1));
        // 返回  3
        System.out.println(cache.get(3));
        // 返回  4
        System.out.println(cache.get(4));
    }

    static class LRUCache {

        class Node {
            int key;
            int val;
            Node prev, next;

            Node() {
            }

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        int cap;
        int size;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            cap = capacity;
            size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                // 被访问到的时候，移动到链表头部
                moveToHead(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                // 更新 val，移动到链表头部
                moveToHead(node);
            } else {
                // 缓冲区满，先删除尾部节点
                if (size == cap) {
                    Node needRemove = tail.prev;
                    removeNode(needRemove);
                    map.remove(needRemove.key);
                    size--;
                }
                Node node = new Node(key, value);
                // 添加节点到链表头部
                addToHead(node);
                map.put(key, node);
                size++;
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
        }
    }
}
