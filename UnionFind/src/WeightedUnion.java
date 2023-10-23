import edu.princeton.cs.algs4.*;

public class WeightedUnion {
    private static int[] root;

    private static void union(int x, int y) {
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

    private static int getRoot(int x) {
        if (root[x] < 0) return x;
        return root[x] = getRoot(root[x]);
    }

    private static boolean connected(int x, int y) {
        int u = getRoot(x);
        int v = getRoot(y);
        return u == v;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        root = new int[n + 5];
        int cnt = 0;
        int connected_components = n;
        for (int i = 0; i < n; i++) {
            root[i] = -1;
        }
        while (!StdIn.isEmpty()) {
            cnt++;
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            if (!connected(x, y)) {
                union(x, y);
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
        //System.out.println("Connected components: " + connected_components);
    }
}