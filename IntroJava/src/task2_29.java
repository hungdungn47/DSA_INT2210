// Calculate day of week
public class task2_29 {
    private static int dayOfWeek(double d, double m, double y) {
        double y0 = y - (14 - m) / 12;
        double x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        double m0 = m + 12 * ((14 - m) / 12) - 2;
        double d0 = (d + x + (31*m0)/ 12) % 7;
        return (int)d0;
    }
    public static void main(String[] args) {
        double d = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        String weekDayName[] = {"Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println(weekDayName[dayOfWeek(d, m, y)]);
    }
}
