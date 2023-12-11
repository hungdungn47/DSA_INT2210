public class Quick {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(less(a[++i], a[lo])) {
                if(i == hi) break;
            }
            while(less(a[lo], a[--j])) {
                if(j == lo) break;
            }
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    public static Comparable select(Comparable[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while(hi > lo) {
            int j = partition(a, lo, hi);
            if(j < k) lo = j + 1;
            else if(j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }
    private static boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args) {
        Integer[] a = new Integer[]{8, 2, 1, 4, 1000, 5, 5, 5};
        int k = 2;
        System.out.println("So nho thu k: " + select(a, k));
    }
}
