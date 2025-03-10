package bonus_hackerrank;

import java.util.Arrays;

public class Solution {
    private static int lowerBound(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        int ans = -1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(a[m] <= target) {
                ans = a[m];
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
    private static int[] solve(int[] n, int [] m) {
        Arrays.sort(n);
        int[] res = new int[m.length];
        for(int i = 0; i < m.length; i++) {
            res[i] = lowerBound(n, m[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] n = new int[]{4, 11, 6, 9};
        int[] m = new int[]{1, 6};
        int[] res = solve(n, m);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}