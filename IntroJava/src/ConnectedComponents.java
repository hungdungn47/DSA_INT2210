import java.util.Scanner;

public class ConnectedComponents {
    public static int[] root = new int[1000];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int cnt = v;
        for (int i = 1; i <= v; i++) {
            root[i] = i;
        }
        int e = input.nextInt();
        for (int i = 0; i < e; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (root[x] != root[y]) {
                for (int j = 1; j <= v; j++) {
                    if (root[j] == root[y]) root[j] = root[x];
                }
                cnt--;
            }
        }
        System.out.println("So thanh phan lien thong: " + cnt);
    }
}
