public class QuickUnionUF {
    private int[] id;
    public QuickUnionUF(int n) {
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public boolean connected(int u, int v) {
        return root(u) == root(v);
    }
    public void union(int u, int v) {
        int i = root(u);
        int j = root(v);
        id[i] = j;
    }
}
