package cn.edu.nju.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/11
 */
public class Assignment166 {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuilder sb = new StringBuilder();
            if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
                sb.append("-");
            }
            long num = Math.abs(Long.valueOf(numerator));
            long d = Math.abs(Long.valueOf(denominator));
            long intPart = num / d;
            sb.append(intPart);
            long r = num % d;
            if (r == 0) {
                return sb.toString();
            }

            sb.append(".");
            StringBuilder decimal = new StringBuilder();
            Map<Node, Integer> map = new HashMap<>();
            int q;
            int i = 0;
            while (r != 0) {
                r *= 10;
                q = (int) (r / d);
                r = r % d;
                Node n = new Node(q, r);
                if (map.containsKey(n)) {
                    int loopStart = map.get(n);
                    decimal.insert(loopStart, '(');
                    decimal.insert(i + 1, ')');
                    return sb.append(decimal).toString();
                }
                decimal.append(q);
                map.put(n, i);
                i++;
            }
            return sb.append(decimal).toString();
        }

        class Node {
            long q;
            long r;

            public Node(long q, long r) {
                this.q = q;
                this.r = r;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Node node = (Node) o;

                if (q != node.q) return false;
                return r == node.r;
            }

            @Override
            public int hashCode() {
                long result = q;
                result = 31 * result + r;
                return (int) result;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(1, 6));
        System.out.println(solution.fractionToDecimal(4, 333));
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(-50, 8));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
    }
}
