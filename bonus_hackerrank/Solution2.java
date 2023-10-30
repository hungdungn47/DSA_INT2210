package bonus_hackerrank;
import java.io.*;
import java.util.*;

public class Solution2 {
    public static int size = 0;
    public static long[] pq = new long[1000001];
    public static void add(long x) {
        pq[++size] = x;
        int k = size;
        while(k > 1 && pq[k] < pq[k / 2]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    public static void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && pq[j] > pq[j + 1]) j++;
            if (pq[k] <= pq[j]) break;
            exch(k, j);
            k = j;
        }
    }
    public static long delMin() {
        long res = pq[1];
        pq[1] = pq[size--];
        sink(1);
        return res;
    }
    public static long getMin() {
        return pq[1];
    }

    public static void exch(int i, int j) {
        long swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    public static long[] value = new long[100005];
    public static long[] res = new long[100005];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        for(int i = 1; i <= n; i++) {
            value[i] = in.nextInt();
        }
        res[0] = 0;

        for(int i = 1; i <= k; i++) {
            res[i] = res[i - 1] + value[i];
            add(value[i]);
        }
        for(int i = k + 1; i <= n; i++) {
            res[i] = res[i - 1];
            if(value[i] > getMin()) {
                res[i] -= delMin();
                res[i] += value[i];
                add(value[i]);
            }
        }
        for(int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
