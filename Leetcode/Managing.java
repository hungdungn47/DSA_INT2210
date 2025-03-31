package Leetcode;

import java.util.Scanner;

public class Managing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();
        int[] v = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            v[i] = in.nextInt();
        }

        // DP table
        int[] dp = new int[N + 1];

        int[] best = new int[K + 1];

        for(int i = 0; i <= N; i++) dp[i] = 0;
        for(int j = 0; j <= K; j++) best[j] = 0;

        for(int i = 1; i <= N; i++) {
            best[0] = Math.max(best[0], dp[i - 1]);
            dp[i] = dp[i - 1];
            for(int j = 0; j < K; j++) {
                if(i - j - 1 >= 0) {
                    dp[i] = Math.max(dp[j], best[j] + v[i]);
                }
            }
            for(int j = K - 1; j >= 1; j--) {
                if(i - j >= 0) {
                    best[j] = best[j - 1] + v[i - j + 1];
                }
            }
        }
        for(int i = 0; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println(dp[N]);
    }
}
