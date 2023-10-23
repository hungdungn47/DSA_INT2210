public class task3_2 {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        if(a == 0) {
            if(b == 0) {
                if(c == 0) {
                    System.out.println("Phuong trinh co nghiem duy nhat la 0");
                } else {
                    System.out.println("Phuong trinh vo nghiem");
                }
            } else {
                double res = - c / b;
                System.out.println("Phuong trinh co nghiem duy nhat la: " + res);
            }
        } else {
            double d = Math.sqrt(b * b - 4 * a * c);
            if(d > 0) {
                double x1 = ( -b + d) / (2 * a);
                double x2 = (-b - d) / (2 * a);
                System.out.println("Phuong trinh co 2 nghiem phan biet: " + x1 + " va " + x2);
            } else if(d == 0) {
                double x = -b / (2 * a);
                System.out.println("Phuong trinh co nghiem duy nhat la: " + x);
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        }
    }
}
