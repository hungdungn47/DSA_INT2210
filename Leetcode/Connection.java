package Leetcode;

import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false;
        }

        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
    }
}


public class Connection {

    public static int minReconnections(int n, List<int[]> connections) {
        UnionFind uf = new UnionFind(n);
        int extraCables = 0;
        int components = n;

        for (int[] conn : connections) {
            if (!uf.union(conn[0], conn[1])) {
                extraCables++;
            } else {
                components--;
            }
        }

        return (extraCables >= (components - 1)) ? (components - 1) : -1;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        List<int[]> connections = new ArrayList<int[]>();

        int N = in.nextInt();
        int M = in.nextInt();
        for(int i = 0; i < M; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            connections.add(new int[] {u, v});

        }
        System.out.print(minReconnections(N, connections));
    }
}
