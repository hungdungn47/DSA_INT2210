import edu.princeton.cs.algs4.*;
import java.util.Arrays;
public class ThreeSum {
    private static int bs(int[] a, int l, int r, int u) {
        while(l <= r) {
            int m = (l + r) / 2;
            if(a[m] == u) {
                return m;
            } else if(a[m] < u) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    private static void solve(int n, int[] a) {
        Arrays.sort(a);
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int l = j + 1;
                int r = n - 1;
                int k = bs(a, l, r, -a[i]-a[j]);
                if(k != -1) {
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }
    private static void solve2(int n, int[] a) {
        Arrays.sort(a);
        for(int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                if(a[i] + a[j] + a[k] == 0) {
                    System.out.println(a[i] + " " + a[j] + " " + a[k]);
                    j++;
                    k--;
                } else if(a[i] + a[j] + a[k] < 0) {
                    j++;
                } else {
                    k--;
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
        solve2(n, a);
    }
}