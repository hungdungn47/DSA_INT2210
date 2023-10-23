public class task3_4 {
    private static boolean solve(double x, double y) {
        return (0 < x && x < 1 && 0 < y && y < 1);
    }
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        System.out.println(solve(x, y));
    }
}
