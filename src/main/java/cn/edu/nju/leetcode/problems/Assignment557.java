package cn.edu.nju.leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/4
 */
public class Assignment557 {
    class Solution {
        public String reverseWords(String s) {
            return Arrays.stream(s.split(" "))
                    .map(str -> {
                        char[] chars = str.toCharArray();
                        char tmp;
                        for (int i = 0; i < chars.length / 2; i++) {
                            tmp = chars[i];
                            chars[i] = chars[chars.length - 1 - i];
                            chars[chars.length - 1 - i] = tmp;
                        }
                        return String.valueOf(chars);
                    })
                    .collect(Collectors.joining(" "));
        }
    }
}
