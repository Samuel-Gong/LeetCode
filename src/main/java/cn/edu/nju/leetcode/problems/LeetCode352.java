package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/11
 */
public class LeetCode352 {
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(3);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(2);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
    }

    /**
     * 利用 TreeMap ceiling, floor, higher, lower 的特性
     * ceiling(>= key) floor(<= key)
     * higher(> key) lower(< key)
     */
    static class SummaryRanges {

        TreeMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Integer> leftEntry = map.floorEntry(val);
            Map.Entry<Integer, Integer> rightEntry = map.ceilingEntry(val);
            if (leftEntry == null && rightEntry == null) {
                map.put(val, val);
                return;
            }
            // union right
            if (rightEntry != null) {
                int right = rightEntry.getKey();
                if (right == val) return;
                if (val + 1 == right) {
                    map.remove(right);
                    map.put(val, rightEntry.getValue());
                } else {
                    map.put(val, val);
                }
            } else {
                map.put(val, val);
            }
            // union left
            if (leftEntry != null) {
                int valRight = map.get(val);
                int left = leftEntry.getKey();
                if (left <= val && val <= leftEntry.getValue()) {
                    map.remove(val);
                } else if (leftEntry.getValue() + 1 == val) {
                    map.remove(val);
                    map.put(left, valRight);
                }
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[map.size()][2];
            int key;
            if (map.size() >= 1) {
                key = map.firstKey();
            } else {
                return res;
            }
            for (int i = 0; i < map.size(); i++) {
                res[i] = new int[]{key, map.get(key)};
                if (i != map.size() - 1) key = map.higherKey(key);
            }
            return res;
        }
    }
}
