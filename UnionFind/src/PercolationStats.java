import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final int experimentsCount;
    private final double[] fraction;
    public PercolationStats(int n, int t) {
        if(n <= 0 || t <= 0) {
            throw new IllegalArgumentException("n and trials must be > 0");
        }
        experimentsCount = t;
        fraction = new double[experimentsCount];
        for(int expNum = 0; expNum < experimentsCount; expNum++) {
            Percolation pr = new Percolation(n);
            int openedSites = 0;
            while(!pr.percolates()) {
                int i = StdRandom.uniformInt(1, n + 1);
                int j = StdRandom.uniformInt(1, n + 1);
                if(!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
                fraction[expNum] = (double)openedSites / (n * n);
            }
        }
    }
    public double mean() {
        return StdStats.mean(fraction);
    }
    public double stddev() {
        return StdStats.stddev(fraction);
    }

    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(experimentsCount));
    }
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(experimentsCount));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        StdOut.println("Mean: " + ps.mean());
        StdOut.println("Standard deviation: " + ps.stddev());
        StdOut.println("95% confidence interval: " + ps.confidenceLo() + ", " + ps.confidenceHi());
    }
}
