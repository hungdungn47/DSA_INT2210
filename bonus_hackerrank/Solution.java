package bonus_hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pair implements Comparable<Pair> {
    int v;
    int wt;
    public Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(Pair other) {
        return this.wt - other.wt;
    }
}

class Result {

    /*
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */

    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        List<Integer> d = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            d.add(Integer.MAX_VALUE - 1);
        }
        d.set(s, 0);
        Set<Integer> unvisited = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            unvisited.add(i);
        }
        while(!unvisited.isEmpty()) {
            int curr = unvisited.iterator().next();
            for(int i : unvisited) {
                if(d.get(i) < d.get(curr)) {
                    curr = i;
                }
            }
            if(d.get(curr) == Integer.MAX_VALUE - 1) continue;
            unvisited.remove(curr);
            for(int j = 0; j < adj.get(curr).size(); j++) {
                Pair it = adj.get(curr).get(j);
                int u = it.v;
                int wt = it.wt;
                if(d.get(u) > d.get(curr) + wt) {
                    d.set(u, d.get(curr) + wt);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i == s) continue;
            if(d.get(i) < Integer.MAX_VALUE - 1) {
                res.add(d.get(i));
            } else {
                res.add(-1);
            }
        }
        return res;
    }

}

public class Solution {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();

        int t = sc.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            int n = sc.nextInt();

            int m = sc.nextInt();

            List<List<Integer>> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {

                List<Integer> edgesRowItems = new ArrayList<>();

                for (int j = 0; j < 3; j++) {
                    int edgesItem = sc.nextInt();
                    edgesRowItems.add(edgesItem);
                }

                edges.add(edgesRowItems);
            }

            int s = sc.nextInt();

            List<Integer> result = Result.shortestReach(n, edges, s);

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));

                if (i != result.size() - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }
}
