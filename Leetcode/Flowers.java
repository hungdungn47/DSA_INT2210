package Leetcode;

import java.util.*;

public class Flowers {
    public static Map<Integer, List<Integer>> availableAfter = new HashMap<>();
    public static int N;
    public static int res = 0;
    public static int[] solution;
    public static void backtrack(int k) {
        for(int i = 0; i <= 4; i++) {
            if(k == 0 || availableAfter.get(i).contains(solution[k - 1])) {
                solution[k] = i;
                if(k == N - 1) {
//                    for(int j = 0; j <= k; j++) {
//                        System.out.print(solution[j] + " ");
//                    }
//                    System.out.println();

                    res++;
                } else {
                    backtrack(k + 1);
                    solution[k] = -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        // Hồng Ly Mai Lan Tulip
        // 0    1  2   3   4
        // 1            -> 0
        // [0 , 2]      -> 1
        // [0, 1, 3, 4] -> 2
        // [2, 4]       -> 3
        // 0            -> 4

        availableAfter.put(0, new ArrayList<>(Arrays.asList(1)));
        availableAfter.put(1, new ArrayList<>(Arrays.asList(0, 2)));
        availableAfter.put(2, new ArrayList<>(Arrays.asList(0, 1, 3, 4)));
        availableAfter.put(3, new ArrayList<>(Arrays.asList(2, 4)));
        availableAfter.put(4, new ArrayList<>(Arrays.asList(0)));

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        solution = new int[N + 1];
        backtrack(0);
        System.out.print(res);
    }
}
