package cn.edu.nju.leetcode.contest.contest_10;

import java.util.*;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/5
 */
public class Assignment1 {
    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            Set<Integer> s1 = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                s1.add(arr1[i]);
            }
            Set<Integer> s2 = new HashSet<>();
            for (int i = 0; i < arr2.length; i++) {
                s2.add(arr2[i]);
            }
            Set<Integer> s3 = new HashSet<>();
            for (int i = 0; i < arr3.length; i++) {
                s3.add(arr3[i]);
            }
            s1.retainAll(s2);
            s1.retainAll(s3);
            List<Integer> res = new ArrayList<>(s1);
            Collections.sort(res);
            return res;
        }
    }
}
