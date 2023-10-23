import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int size;
    private final int top = 0;
    private final int bottom;
    private int openSites = 0;
    private boolean[][] opened;
    private WeightedQuickUnionUF uf;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N has to be >= 0");
        }
        size = n;
        bottom = size * size + 1;
        opened = new boolean[size][size];
        uf = new WeightedQuickUnionUF(size * size + 2);
        openSites = 0;
    }

    private void checkException(int row, int col) {
        if (row < 1 || row > size || col < 0 || col > size) {
            throw new IllegalArgumentException("Out of grid");
        }
    }

    private int getIndex(int row, int col) {
        return (row - 1) * size + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkException(row, col);
        opened[row - 1][col - 1] = true;
        openSites++;
        // If any of the top sites are opened: union(it, top)
        if (row == 1) {
            uf.union(top, getIndex(row, col));
        }
        // If any of the bottom sites are opened: union(it, bottom)
        if (row == size) {
            uf.union(bottom, getIndex(row, col));
        }
        // Neighboring unions
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getIndex(row, col), getIndex(row - 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getIndex(row, col), getIndex(row, col - 1));
        }
        if (row < size && isOpen(row + 1, col)) {
            uf.union(getIndex(row, col), getIndex(row + 1, col));
        }
        if (col < size && isOpen(row, col + 1)) {
            uf.union(getIndex(row, col), getIndex(row, col + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkException(row, col);
        return opened[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkException(row, col);
        return uf.connected(getIndex(row, col), top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}