package cn.edu.nju.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/29
 */
public class Assignment900 {
    class RLEIterator {

        Deque<Integer> len = new ArrayDeque<>();
        Deque<Integer> num = new ArrayDeque<>();

        public RLEIterator(int[] A) {
            for (int i = 0; i < A.length; i += 2) {
                len.addLast(A[i]);
                num.addLast(A[i + 1]);
            }
        }

        public int next(int n) {
            while (n > 0) {
                if (len.isEmpty()) {
                    return -1;
                }
                int l = len.removeFirst();
                if (l > n) {
                    l -= n;
                    len.addLast(l);
                    return num.peekFirst();
                } else if (l == n) {
                    return num.removeFirst();
                } else {
                    n -= l;
                    num.removeFirst();
                }
            }
            return -1;
        }
    }

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
}
