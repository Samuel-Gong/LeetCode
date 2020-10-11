package cn.edu.nju.leetcode.problems;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2020/10/11
 */
public class LeetCode273 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(100));
        System.out.println(solution.numberToWords(123));
        System.out.println(solution.numberToWords(12345));
        System.out.println(solution.numberToWords(1234567));
        System.out.println(solution.numberToWords(1234567891));
    }

    static class Solution {
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        int hundred = 100;
        int ten = 10;
        String[] digitMap = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] withinTwentyMap = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tenDigitMap = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] unit = new String[]{"Thousand", "Million", "Billion"};
        int[] unitVal = new int[]{thousand, million, billion};

        public String numberToWords(int num) {
            if (num == 0) return digitMap[num];
            StringBuilder sb = new StringBuilder();
            // 转换 billion 部分
            String billionPart = convertPart(num, 2);
            sb.append(billionPart);
            num = num % unitVal[2];
            // 转换 million 部分
            String millionPart = convertPart(num, 1);
            if (millionPart.length() != 0) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(millionPart);
            }
            num = num % unitVal[1];
            // 转换 thousand 部分
            String thousandPart = convertPart(num, 0);
            if (thousandPart.length() != 0) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(thousandPart);
            }
            num = num % unitVal[0];
            // 转换 hundred 部分
            String hundredPart = convertHundred(num);
            if (hundredPart.length() != 0) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(hundredPart);
            }
            return sb.toString();
        }

        private String convertPart(int num, int unit) {
            StringBuilder sb = new StringBuilder();
            // part 必定为三位数
            int part = num / unitVal[unit];
            if (part != 0) sb.append(convertHundred(part)).append(" ").append(this.unit[unit]);
            return sb.toString();
        }

        private String convertHundred(int num) {
            StringBuilder sb = new StringBuilder();
            // hundred 部分
            int hundredPart = num / hundred;
            if (hundredPart > 0) sb.append(digitMap[hundredPart]).append(" ").append("Hundred");
            num = num % hundred;
            // 20 及其以上
            int tenPart = num / ten;
            if (tenPart > 0) {
                if (sb.length() != 0) sb.append(" ");
                if (tenPart >= 2) {
                    sb.append(tenDigitMap[tenPart - 2]);
                    num = num % 10;
                    if (num > 0) {
                        sb.append(" ").append(digitMap[num]);
                    }
                } else {
                    sb.append(withinTwentyMap[num - 10]);
                }
            } else if (num > 0) {
                if (sb.length() != 0) sb.append(" ");
                sb.append(digitMap[num]);
            }
            return sb.toString();
        }
    }
}
