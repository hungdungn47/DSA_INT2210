package bonus_hackerrank;

import java.util.Scanner;

public class SegmentTree {
    public static int[] a = new int[1000];
    public static int[] t = new int[4000];
    public static void build(int l, int r, int id) {
        if(l == r) {
            t[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, 2 * id);
        build(mid + 1, r, 2 * id + 1);
        t[id] = Math.max(t[2 * id], t[2 * id + 1]);
    }
    public static int get(int l, int r, int id, int u, int v) {
        if(v < l || r < u) {
            return Integer.MIN_VALUE;
        }
        if(u <= l && r <= v) {
            return t[id];
        }
        int mid = (l + r) / 2;
        int t1 = get(l, mid, id * 2, u, v);
        int t2 = get(mid + 1, r, id * 2 + 1, u, v);
        return Math.max(t1, t2);
    }
    public static void update(int l, int r, int id, int pos, int val) {
        if(pos < l || r < pos) return;
        if(l == r) {
            t[id] = val;
            a[l] = val;
            return;
        }
        int mid = (l + r) / 2;
        update(l, mid, 2 * id, pos, val);
        update(mid + 1, r, 2 * id + 1, pos, val);
        t[id] = Math.max(t[2 * id], t[2 * id + 1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        build(1, n, 1);
        int numOfQuery = in.nextInt();
        while(numOfQuery-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(get(1, n, 1, l, r));
        }
    }
}