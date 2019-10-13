package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/3
 */
public class Assignment1090 {
    static class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
            if (use_limit == 0) {
                return 0;
            }
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                pairs.add(new Pair(values[i], labels[i]));
            }

            pairs.sort((p1, p2) -> {
                if (p1.v < p2.v) {
                    return 1;
                } else if (p1.v > p2.v) {
                    return -1;
                }
                return p1.l - p2.l;
            });

            Map<Integer, Integer> m = new HashMap<>();
            int num = 0;
            int sum = 0;
            Integer use;
            for (Pair p : pairs) {
                use = m.get(p.l);
                if (use != null) {
                    if (use < use_limit) {
                        sum += p.v;
                        m.put(p.l, ++use);
                        if (++num == num_wanted) {
                            break;
                        }
                    }
                } else {
                    sum += p.v;
                    m.put(p.l, 1);
                    if (++num == num_wanted) {
                        break;
                    }
                }
            }

            return sum;
        }

        class Pair {
            int v;
            int l;

            Pair(int v, int l) {
                this.v = v;
                this.l = l;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 2));
    }
}
