package bonus_hackerrank;
import java.io.*;
import java.util.*;

class MinPQ {
    public int size = 0;
    public int[] pq = new int[2000005];
    public void add(int x) {
        pq[++size] = x;
        int k = size;
        while(k > 1 && pq[k] < pq[k / 2]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && pq[j] > pq[j + 1]) j++;
            if (pq[k] <= pq[j]) break;
            exch(k, j);
            k = j;
        }
    }
    public int delMin() {
        int res = pq[1];
        pq[1] = pq[size--];
        sink(1);
        return res;
    }
    public int getMin() {
        return pq[1];
    }

    public void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
class MaxPQ {
    public int size = 0;
    public int[] pq = new int[200005];
    public void add(int x) {
        pq[++size] = x;
        int k = size;
        while(k > 1 && pq[k] > pq[k / 2]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && pq[j] < pq[j + 1]) j++;
            if (pq[k] >= pq[j]) break;
            exch(k, j);
            k = j;
        }
    }
    public int delMax() {
        int res = pq[1];
        pq[1] = pq[size--];
        sink(1);
        return res;
    }
    public int getMax() {
        return pq[1];
    }

    public void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
public class Solution {
    public static MaxPQ firstHalf = new MaxPQ();
    public static MinPQ secondHalf = new MinPQ();
    public static int peekMed() {
        if(firstHalf.isEmpty()) {
            return 0;
        }
        return firstHalf.getMax();
    }
    public static void removeMed() {
        firstHalf.delMax();
        update();
    }
    public static void update() {
        if(firstHalf.size < secondHalf.size) {
            firstHalf.add(secondHalf.delMin());
        } else if(firstHalf.size > secondHalf.size + 1) {
            secondHalf.add(firstHalf.delMax());
        }
    }
    public static void insert(int x) {
        if(x <= peekMed()) {
            firstHalf.add(x);
        } else {
            secondHalf.add(x);
        }
        update();
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            insert(x);
        }
        while(m-- > 0) {
            int q = in.nextInt();
            if(q == 1) {
                int u = in.nextInt();
                insert(u);
            } else if(q == 2) {
                removeMed();
            } else {
                System.out.println(peekMed());
            }
        }
    }
}
