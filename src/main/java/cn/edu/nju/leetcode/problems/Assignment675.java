package cn.edu.nju.leetcode.problems;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/13
 */
public class Assignment675 {
    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            PriorityQueue<Place> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));
            List<Integer> row;
            for (int i = 0; i < forest.size(); i++) {
                row = forest.get(i);
                for (int j = 0; j < row.size(); j++) {
                    if (row.get(j) > 1) {
                        pq.add(new Place(i, j, row.get(j)));
                    }
                }
            }
            int res = 0;
            Place cur = new Place(0, 0, 0);
            int step;
            while (!pq.isEmpty()) {
                Place place = pq.poll();
                step = forward(forest, cur, place);
                if (step >= 0) {
                    forest.get(cur.x).set(cur.y, 1);
                    cur = place;
                    res += step;
                } else {
                    return -1;
                }
            }
            return res;
        }

        private int forward(List<List<Integer>> forest, Place cur, Place dest) {
            Deque<Place> places = new ArrayDeque<>();
            places.add(cur);
            int step = 0;
            while (!places.isEmpty()) {
                Place place = places.poll();
                if (place.x == dest.x && place.y == dest.y) {

                }
            }
            return -1;
        }

        class Place {
            int x;
            int y;
            int val;

            public Place(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }
    }
}
