import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Collections;
import java.util.Vector;

public class NSum {
    public static Vector<Integer> all_sum1;
    public static Vector<Integer> all_sum2;
    public static int[] arr;
    public static Vector<Integer> sub_arr1;
    public static Vector<Integer> sub_arr2;
    public static int n;
    public static int res = 1;
    public static void generate_all_sum() {
        for(int i = 0; i < n / 2; i++) {
            sub_arr1.add(arr[i]);
        }
        for(int i = n / 2; i < n; i++) {
            sub_arr2.add(arr[i]);
        }
        all_sum1.add(0);
        all_sum2.add(0);
        for (int k : sub_arr1) {
            int current_size = all_sum1.size();
            for (int j = 0; j < current_size; j++) {
                all_sum1.add(all_sum1.get(j) + k);
            }
        }
        for(int k : sub_arr2) {
            int current_size = all_sum2.size();
            for(int j = 0; j < current_size; j++) {
                all_sum2.add(all_sum2.get(j) + k);
            }
        }

        all_sum1.remove(0);
        all_sum2.remove(0);
    }
    public static void solve() {
        for(int x : all_sum1) {
            if(x == 0) res++;
            for(int y : all_sum2) {
                if(x + y == 0) {
                    res++;
                }
            }
        }
        for(int y : all_sum2) {
            if(y == 0) res++;
        }
    }
    public static void main(String[] args) {
        n = StdIn.readInt();
        arr = new int[n];
        sub_arr1 = new Vector<>(21);
        sub_arr2 = new Vector<>(21);
        all_sum1 = new Vector<>(10000);
        all_sum2 = new Vector<>(10000);
        for(int i = 0; i < n; i++) {
            arr[i] = StdIn.readInt();
        }
        generate_all_sum();
        solve();
        System.out.println(res);
    }
}
