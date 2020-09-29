package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/6/10
 */
public class LeetCode9 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1000000001));
        System.out.println(solution.isPalindrome(1000030001));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isPalindrome(10));
        System.out.println(solution1.isPalindrome(1000000001));
        System.out.println(solution1.isPalindrome(1000030001));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            // 数量级
            int om = 0;
            int num = x;
            while (num >= 10) {
                num = num / 10;
                om++;
            }
            int l = om;
            int r = 0;
            while (l > r) {
                int left = (x / (int) Math.pow(10, l)) % 10;
                int right = (x / (int) Math.pow(10, r)) % 10;
                if (left != right) return false;
                l--;
                r++;
            }
            return true;
        }
    }

    /**
     * 巧妙解法
     * <p>
     * 将数字翻转一半，通过除法和取余操作，比较剩下的一半数字和翻转得到的另一半数字
     * <p>
     * 注意判断区分奇偶的情况
     */
    static class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            int revertNum = 0;
            while (x > revertNum) {
                int remainder = x % 10;
                revertNum = revertNum * 10 + remainder;
                x /= 10;
            }
            // 偶数情况下，剩下一半数字的位数 = 翻转数字的位数
            // 奇数情况下，翻转数字的位数会多一位，除以 10 排除掉最后一位再进行比较
            return x == revertNum || x == revertNum / 10;
        }
    }
}
