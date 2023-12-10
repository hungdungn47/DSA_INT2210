public class WeightedUnionUF {
    private int[] id;
    private int[] sz;
    public WeightedUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    private int root(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];
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
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
