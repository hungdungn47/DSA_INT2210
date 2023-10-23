public class task2_25 {
    private static double wind_chill(double t, double v) {
        return (13.12 + 0.6215 * t - 11.37 * Math.pow(v, 0.16) + 0.3965 * t * Math.pow(v, 0.16));
    }
    public static void main(String[] args) {
        double t = Double.parseDouble(args[0]);
        double v = Double.parseDouble(args[1]);
        System.out.println(wind_chill(t, v));
    }
}
