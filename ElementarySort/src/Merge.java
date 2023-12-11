public class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int hi, int mid) {
        for(int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = a[j++];
            else if(j > hi) a[k] = a[i++];
            else if(less(a[j], a[i])) a[k] = a[j++];
            else a[k] = a[i++];
        }
    }
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, hi, mid);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
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
        Integer[] a = new Integer[]{8, 2, 1, 4, 5};
        Insertion.sort(a);
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
