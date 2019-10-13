package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/12
 */
public class Assignment798 {
    static class Solution {
        public int bestRotation(int[] A) {
            List<Node> ks = new ArrayList<>();
            int kLo;
            int kHi;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= A.length) {
                    continue;
                }
                if (i < A[i]) {
                    kLo = i + 1;
                    kHi = kLo + A.length - A[i] - 1;
                    if (kHi >= kLo) {
                        ks.add(new Node(kLo, false));
                        ks.add(new Node(kHi, true));
                    }
                } else {
                    if (i >= A[i]) {
                        if (A[i] > 0) {
                            kLo = 0;
                            kHi = i - A[i];
                            ks.add(new Node(kLo, false));
                            ks.add(new Node(kHi, true));
                            kLo = i + 1;
                            kHi = kLo + A.length - A[i] - 1;
                            ks.add(new Node(kLo, false));
                            ks.add(new Node(kHi, true));
                        } else {
                            kLo = 0;
                            kHi = A.length - 1;
                            ks.add(new Node(kLo, false));
                            ks.add(new Node(kHi, true));
                        }
                    }
                }
            }

            ks.sort((n1, n2) -> {
                if (n1.v == n2.v) {
                    if (n1.end == n2.end) {
                        return 0;
                    } else if (n1.end) {
                        return 1;
                    }
                    return -1;
                }
                return n1.v - n2.v;
            });

            int max = 0;
            int index = 0;
            int cur = 0;
            for (Node n : ks) {
                cur = n.end ? --cur : ++cur;
                if (max < cur) {
                    max = cur;
                    index = n.v;
                }
            }

            return index;
        }

        class Node {
            int v;
            boolean end;

            Node(int v, boolean end) {
                this.v = v;
                this.end = end;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(solution.bestRotation(new int[]{1, 3, 0, 2, 4}));
        System.out.println(solution.bestRotation(new int[]{67, 96, 36, 38, 77, 19, 80, 78, 38, 40, 94, 61, 37, 59, 98, 7, 37, 10, 61, 29, 81, 92, 38, 31, 5, 65, 13, 58, 19, 81, 81, 4, 27, 67, 22, 30, 5, 20, 38, 50, 89, 56, 99, 23, 46, 62, 81, 56, 98, 42, 43, 92, 57, 73, 74, 89, 52, 95, 5, 99, 15, 95, 79, 20, 3, 70, 29, 48, 36, 74, 36, 30, 30, 25, 71, 76, 49, 3, 17, 70, 23, 99, 37, 60, 0, 57, 5, 32, 14, 20, 2, 71, 7, 39, 19, 96, 9, 35, 31, 14}));
    }
}
