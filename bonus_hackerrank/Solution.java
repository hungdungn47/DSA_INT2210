package bonus_hackerrank;
import java.io.*;
import java.util.*;

public class Solution {
    public static int[] queue = new int[100005];
    public static int n = 0;
    public static void insert(int u) {
        int index = 0;
        while(index <= n) {
            if(queue[index] <= u && u <= queue[index + 1]) {
                break;
            }
            index++;
        }
        for(int i = n + 2; i > index + 1; i--) {
            queue[i] = queue[i - 1];
        }
        queue[index + 1] = u;
        n++;
    }
    public static void popMed() {
        int index = (n + 1) / 2;
        for(int i = index; i < n + 1; i++) {
            queue[i] = queue[i + 1];
        }
        n--;
    }
    public static void printQueue() {
        for(int i = 1; i <= n; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    public static void showMed() {
        int index = (n + 1) / 2;
        System.out.println(queue[index]);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        queue[0] = 0;
        queue[n + 1] = Integer.MAX_VALUE;
        // n sinh vien duoc luu tu chi so 1 den n

        int initSize = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < initSize; i++) {
            int x = in.nextInt();
            insert(x);
        }

        while(m-- > 0) {
            int q = in.nextInt();
            if(q == 1) {
                int u = in.nextInt();
                insert(u);
            } else if(q == 2) {
                popMed();
            } else {
                showMed();
            }
        }
    }
}
