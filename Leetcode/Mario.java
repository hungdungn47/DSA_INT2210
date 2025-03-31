package Leetcode;

import java.util.Scanner;

public class Mario {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int n = in.nextInt();

            if(n%4 != 0) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
