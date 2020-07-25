package cn.edu.nju.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author Shenmiu
 * @date 2020/7/25
 */
public class LeetCode93 {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode93 solution = new LeetCode93();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
//        System.out.println(solution.restoreIpAddresses("000"));
    }

    public List<String> restoreIpAddresses(String s) {
        recursive(s, "", 0, 0);
        return res;
    }

    private void recursive(String s, String str, int idx, int parts) {
        if (parts == 4) {
            if (idx == s.length()) {
                res.add(str);
            }
            return;
        }
        // 每次截取 1 ~ 3 位，转换为数字进行判断
        for (int i = 1; i <= 3 && i + idx <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(idx, i + idx));
            if (num > 255) {
                return;
            }
            // 排除掉高位为 0 的情况
            if (String.valueOf(num).length() != i) {
                return;
            }
            if (parts != 3) {
                recursive(s, str + num + ".", i + idx, parts + 1);
            } else {
                recursive(s, str + num, i + idx, parts + 1);
            }
        }
    }
}
