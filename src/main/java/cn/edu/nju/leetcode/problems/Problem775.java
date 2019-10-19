package cn.edu.nju.leetcode.problems;

import java.util.Arrays;

/**
 * <p>
 * <p>
 *
 * @author Shenmiu
 * @date 2019/10/19
 */
public class Problem775 {
    static class Solution {

        private int[] aux;

        public boolean isIdealPermutation(int[] A) {
            aux = new int[A.length];
            int global = globalInversions(Arrays.copyOf(A, A.length));
            int local = localInversions(Arrays.copyOf(A, A.length));
            return global == local;
        }

        private int localInversions(int[] a) {
            int res = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i]) {
                    res++;
                }
            }
            return res;
        }

        private int globalInversions(int[] a) {
            return sort(a, 0, a.length - 1);
        }

        private int sort(int[] arr, int lo, int hi) {
            if (lo == hi) {
                return 0;
            }
            int mid = lo + (hi - lo) / 2;
            int res = 0;
            res += sort(arr, lo, mid);
            res += sort(arr, mid + 1, hi);
            return res + merge(arr, lo, mid, hi);
        }

        private int merge(int[] arr, int lo, int mid, int hi) {
            int l = lo;
            int r = mid + 1;
            System.arraycopy(arr, lo, aux, lo, hi - lo + 1);
            int res = 0;
            for (int i = lo; i <= hi; i++) {
                if (l > mid) arr[i] = aux[r++];
                else if (r > hi) arr[i] = aux[l++];
                else if (aux[l] <= aux[r]) arr[i] = aux[l++];
                else {
                    arr[i] = aux[r++];
                    res += mid - l + 1;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(solution.isIdealPermutation(new int[]{1, 2, 0}));
        System.out.println(solution.isIdealPermutation(new int[]{2, 0, 1}));
        System.out.println(solution.isIdealPermutation(new int[]{0, 3, 1, 2}));
    }
}
