import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class TwoSum {
    private static void solve(int n, int[] a) {
        Arrays.sort(a);
        for(int i = 0; i < n - 1; i++) {
            int l = i + 1;
            int r = n - 1;
            while(l <= r) {
                int m = (l + r) / 2;
                if(a[m] + a[i] == 0) {
                    System.out.println(a[i] + " " + a[m]);
                    break;
                } else if(a[m] + a[i] < 0) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }
        solve(n, a);
    }
}
