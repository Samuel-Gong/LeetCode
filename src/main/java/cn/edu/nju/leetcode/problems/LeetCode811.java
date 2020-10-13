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
 * @date 2020/10/13
 */
public class LeetCode811 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    static class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < cpdomains.length; i++) {
                String[] arr = cpdomains[i].split(" ");
                int cnt = Integer.parseInt(arr[0]);
                String[] domainParts = arr[1].split("\\.");
                String curDomain = domainParts[domainParts.length - 1];
                map.put(curDomain, map.getOrDefault(curDomain, 0) + cnt);
                for (int j = domainParts.length - 2; j >= 0; j--) {
                    curDomain = domainParts[j] + "." + curDomain;
                    map.put(curDomain, map.getOrDefault(curDomain, 0) + cnt);
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }
}
