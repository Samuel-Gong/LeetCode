package cn.edu.nju.leetcode.problems;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/9/26
 */
public class Assignment1094 {
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < trips.length; i++) {
                nodes.add(new Node(trips[i][1], trips[i][0]));
                nodes.add(new Node(trips[i][2], -trips[i][0]));
            }

            Collections.sort(nodes);
            int onCar = 0;
            for (Node n : nodes) {
                onCar += n.v;
                if (onCar > capacity) return false;
            }
            return true;
        }

        class Node implements Comparable<Node> {
            int l;
            int v;

            public Node(int l, int v) {
                this.l = l;
                this.v = v;
            }

            @Override
            public int compareTo(Node o) {
                if (this.l > o.l) return 1;
                if (this.l < o.l) return -1;
                return this.v - o.v;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println(solution.carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
    }
}
