public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for(int j = i + 1; j < N; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
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
