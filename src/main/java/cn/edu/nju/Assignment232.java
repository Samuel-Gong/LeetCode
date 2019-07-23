package cn.edu.nju;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019-07-13
 */
public class Assignment232 {

    static class MyQueue {

        Deque<Integer> enque;
        Deque<Integer> deque;

        int front;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            enque = new ArrayDeque<>();
            deque = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (enque.isEmpty()) {
                front = x;
            }
            enque.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (deque.isEmpty()) {
                while (!enque.isEmpty()) {
                    deque.push(enque.pop());
                }
            }
            return deque.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!deque.isEmpty()) {
                return deque.peek();
            }
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return enque.isEmpty() && deque.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        System.out.println(queue.empty()); // 返回 false
    }
}
