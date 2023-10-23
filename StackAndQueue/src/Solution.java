import java.io.*;
import java.util.*;


public class Solution {
    public int size = 0;
    public int[] queue = new int[1005];
    public void enqueue() {
        int x;
        if(size == 0) {
            x = 0;
        }
        else x = queue[size - 1];
        queue[size++] = x + 1;
    }
    public int dequeue() {
        int res = queue[0];
        for(int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        return res;
    }
    public int pop_last() {
        int res = queue[size - 1];
        size--;
        return res;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        Solution s = new Solution();
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < m; i++) {
            int q = in.nextInt();
            if(q == 1) {
                s.enqueue();
            } else if(q == 2) {
                System.out.println(s.dequeue());
            } else if(q == 3) {
                System.out.println(s.pop_last());
            } else if(q == 4) {
                System.out.println(s.size);
            } else {
                int u = in.nextInt();
                if(u <= s.size) {
                    System.out.println(s.queue[u - 1]);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}