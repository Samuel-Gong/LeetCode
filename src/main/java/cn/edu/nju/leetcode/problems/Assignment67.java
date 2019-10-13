package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/5
 */
public class Assignment67 {
    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = 1;
            int c = 0;
            int r = 0;
            int cal = 0;
            char ac;
            char bc;
            while (a.length() - i >= 0 && b.length() - i >= 0) {
                ac = a.charAt(a.length() - i);
                bc = b.charAt(b.length() - i);
                cal = ac - '0' + bc - '0' + c;
                r = cal % 2;
                c = cal / 2;
                sb.append((char) ('0' + r));
                i++;
            }
            while (a.length() - i >= 0) {
                ac = a.charAt(a.length() - i);
                cal = c + ac - '0';
                r = cal % 2;
                c = cal / 2;
                sb.append((char) ('0' + r));
                i++;
            }
            while (b.length() - i >= 0) {
                bc = b.charAt(b.length() - i);
                cal = c + bc - '0';
                r = cal % 2;
                c = cal / 2;
                sb.append((char) ('0' + r));
                i++;
            }
            if (c == 1) {
                sb.append((char) ('0' + c));
            }

            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
