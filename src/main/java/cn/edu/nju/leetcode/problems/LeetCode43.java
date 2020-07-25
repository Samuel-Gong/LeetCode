package cn.edu.nju.leetcode.problems;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author Shenmiu
 * @date 2020/7/23
 */
public class LeetCode43 {

    public static void main(String[] args) {
        LeetCode43 solution = new LeetCode43();
        System.out.println(solution.multiply("2", "3"));
        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply2("123", "456"));
        System.out.println(solution.multiply2("2", "3"));
    }

    /**
     * 普通竖式
     * 用乘数去乘被乘数，对乘数的每一位，进行循环
     * <p>
     * 比如 123 * 456
     * 被乘数为 123，乘数为 456
     * 2 * 456，因为 2 是 10 位，此时先将乘数扩大 10 倍，即在末尾插入一个 0
     * 循环两次，在结果上每次加上 4560
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb1.length(); i++) {
            int digit = sb1.charAt(i) - '0';
            for (int j = 0; j < digit; j++) {
                add(res, sb2);
            }
            sb2.insert(0, '0');
        }
        return res.reverse().toString();
    }

    private void add(StringBuilder res, StringBuilder sb2) {
        int carry = 0;
        int i;
        int num1, num2;
        for (i = 0; i < res.length() || i < sb2.length(); i++) {
            num1 = i >= res.length() ? 0 : res.charAt(i) - '0';
            num2 = i >= sb2.length() ? 0 : sb2.charAt(i) - '0';
            int tmp = num1 + num2 + carry >= 10 ? 1 : 0;
            if (i >= res.length()) {
                res.append((char) ('0' + (num1 + num2 + carry) % 10));
            } else {
                res.setCharAt(i, (char) ('0' + (num1 + num2 + carry) % 10));
            }
            carry = tmp;
        }
        if (carry > 0) {
            res.append((char) ('0' + carry));
        }
    }

    /**
     * 优化竖式
     * <p>
     * num1 length 为 len1
     * num2 length 为 len2
     * <p>
     * num1 * num2 结果的值位数不会超过 len1 + len2
     * 以左边为低位开始算，num1 的第 i 位 * num2 的第 j 位
     * 计算所得的个位数应该在最终结果中的 i+j 位
     * 如有十位数，则十位数在最终结果中的 i+j+1 位
     */
    public String multiply2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num1);
        int[] res = new int[num1.length() + num2.length()];
        num1 = sb.reverse().toString();
        sb = new StringBuilder(num2);
        num2 = sb.reverse().toString();
        int n1, n2;
        // 乘数
        for (int i = 0; i < num1.length(); i++) {
            n1 = num1.charAt(i) - '0';
            // 被乘数
            for (int j = 0; j < num2.length(); j++) {
                n2 = num2.charAt(j) - '0';
                int sum = res[i + j] + n1 * n2;
                res[i + j] = sum % 10;
                res[i + j + 1] += sum / 10;
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i < res.length - 1; i++) {
            sb.append(res[i]);
        }
        if (res[res.length - 1] != 0) {
            sb.append(res[res.length - 1]);
        }
        return sb.reverse().toString();
    }
}
