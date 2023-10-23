import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int connected_components = N;
        int cnt = 0;
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            cnt++;
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                connected_components--;
                if(connected_components == 1) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
        if(connected_components > 1) {
            System.out.println("FAILED");
        }
    }
}
