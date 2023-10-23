public class task2_35 {
    private static String reverse_string(String s) {
        StringBuilder res = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            StringBuilder append = res.append(s.charAt(i));
        }
        return res.toString();
    }
    private static String replace_r_l(String s) {
        StringBuilder res = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                res.setCharAt(i, 'L');
            } else if(s.charAt(i) == 'L') {
                res.setCharAt(i, 'R');
            }
        }
        return res.toString();
    }
    public static String DragonFractal(int n) {
        if(n == 0) return "F";
        String prev_fractal = DragonFractal(n - 1);
        String res = prev_fractal + 'L' + replace_r_l(reverse_string(prev_fractal));

        return res;
    }
    public static void main(String[] args) {
        System.out.print(DragonFractal(3));
    }
}