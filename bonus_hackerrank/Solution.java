package bonus_hackerrank;
import java.io.*;
import java.util.*;
class Pair {
    int key;
    int val;
    Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < n - 1; i++) {
            int q = in.nextInt();
            if(q == 1) {
                int u = in.nextInt();
                pq.add(new Pair(i + 1, u));
            } else {
                int v = in.nextInt();
                while(!pq.isEmpty() && pq.size() >= v) {
                    pq.poll();
                }
            }
        }
        in.nextInt();
        int v = in.nextInt();
        List<Integer> res = new ArrayList<>();
        long money = 0;
        while(!pq.isEmpty()) {
            Pair tmp = pq.poll();
            money += tmp.val;
            res.add(tmp.key);
        }
        if(res.size() < v) {
            System.out.println(-1);
        } else {
            System.out.println(money);
            Collections.sort(res);
            for(int x : res) {
                System.out.print(x + " ");
            }
        }
    }
}