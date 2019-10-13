package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/7
 */
public class Assignment880 {
    static class Solution {
        public String decodeAtIndex(String S, int K) {
            long base = 0;
            char c;
            int i;
            for (i = 0; i < S.length(); i++) {
                c = S.charAt(i);
                base = Character.isDigit(c) ? base * (c - '0') : base + 1;
                if (base >= K) {
                    break;
                }
            }

            for (; i >= 0; i--) {
                c = S.charAt(i);
                if (Character.isDigit(c)) {
                    base /= (c - '0');
                    K %= base;
                } else {
                    if (K == base || K == 0) {
                        return c + "";
                    }
                    base--;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.decodeAtIndex("leet2code3", 5));
//        System.out.println(solution.decodeAtIndex("ha22", 5));
//        System.out.println(solution.decodeAtIndex("a2345678999999999999999", 1));
//        System.out.println(solution.decodeAtIndex("y959q969u3hb22odq595", 222280369));
//        System.out.println(solution.decodeAtIndex("a23", 6));
//        System.out.println(solution.decodeAtIndex("a2b3c4d5e6f7g8h9", 9));
//        System.out.println(solution.decodeAtIndex("vk6u5xhq9v", 554));
//        System.out.println(solution.decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp", 976159153));
        System.out.println(solution.decodeAtIndex("czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps", 768077956));
    }
}
