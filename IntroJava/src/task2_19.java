public class task2_19 {
    private static int sinh_so_ngau_nhien(int a, int b) {
        int res = (int)(Math.random() * (b - a + 1) + a);
        return res;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(sinh_so_ngau_nhien(a, b)); 
    }
}
