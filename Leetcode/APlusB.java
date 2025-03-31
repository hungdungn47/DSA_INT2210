package Leetcode;

import java.util.*;

public class APlusB {
    public static int solve(int n, int k) {
        if(n == 1 && k == 1) {
            return 0;
        }
        double length = Math.pow(2, n - 1);
        if(k <= length / 2) return solve(n - 1, k);
        else return 1 - solve(n , (int)(k - length / 2));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            if(solve(n, k) == 0) {
                System.out.println('X');
            } else {
                System.out.println('Y');
            }
        }
    }
}