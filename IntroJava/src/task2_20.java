public class task2_20 {
    private static int SumOfTwoDices() {
        int dice1 = (int)(Math.random() * 6 + 1);
        int dice2 = (int)(Math.random() * 6 + 1);
        return dice1 + dice2;
    }
    public static void main(String[] args) {
        System.out.println(SumOfTwoDices());
    }
}