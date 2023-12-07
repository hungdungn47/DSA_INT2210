import edu.princeton.cs.algs4.StdIn;

public class UnionFind {
    private int[] root;

    public UnionFind(int N) {
        root = new int[N + 5];
        for (int i = 0; i <= N; i++) {
            root[i] = -1;
        }
    }
    public void union(int x, int y) {
        x = getRoot(x);
        y = getRoot(y);
        if (root[x] < root[y]) {
            int size_x = root[x];
            int size_y = root[y];
            root[y] = x;
            root[x] = size_x + size_y;
        } else {
            int size_x = root[x];
            int size_y = root[y];
            root[x] = y;
            root[y] = size_x + size_y;
        }
    }

    private int getRoot(int x) {
        if (root[x] < 0) return x;
        return root[x] = getRoot(root[x]);
    }

    public boolean connected(int x, int y) {
        int u = getRoot(x);
        int v = getRoot(y);
        return u == v;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int cnt = 0;
        UnionFind uf = new UnionFind(n);
        int connected_components = n;
        while (!StdIn.isEmpty()) {
            cnt++;
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            if (!uf.connected(x, y)) {
                uf.union(x, y);
                connected_components--;
            }
            if (connected_components == 1) {
                System.out.println(cnt);
                return;
            }
        }
        if (connected_components > 1) {
            System.out.println("FAILED");
        }
       // System.out.println("Connected components: " + connected_components);
    }
}
