import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] check;

    private WeightedQuickUnionUF check1D;
    private WeightedQuickUnionUF check1DIsFull;
    private int count = 0;

    private int numOpenSites;
    private int topSite;
    private int bottomSite;

    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        check = new boolean[N][N];
        check1D = new WeightedQuickUnionUF(N * N + 2);
        check1DIsFull = new WeightedQuickUnionUF(N * N + 1);
        topSite = N * N;
        bottomSite = N * N + 1;
    }

    public void open(int row, int col) {
        if (check[row][col]) {
            return;
        }
        check[row][col] = true;
        int key1D = xyTo1D(row, col);
        if (row == 0) {
            if (!check1D.connected(key1D, topSite)) {
                check1D.union(key1D, topSite);
                check1DIsFull.union(key1D, topSite);
            }
        }
        if (row == check.length - 1) {
            if (!check1D.connected(key1D, bottomSite)) {
                check1D.union(key1D, bottomSite);
            }
        }
        if (row > 0) {
            if (check[row - 1][col]) {
                if (!check1DIsFull.connected(key1D, xyTo1D(row - 1, col))) {
                    check1D.union(key1D, xyTo1D(row - 1, col));
                    check1DIsFull.union(key1D, xyTo1D(row - 1, col));
                }
            }
        }
        if (row < check.length - 1) {
            if (check[row + 1][col]) {
                if (!check1DIsFull.connected(key1D, xyTo1D(row + 1, col))) {
                    check1D.union(key1D, xyTo1D(row + 1, col));
                    check1DIsFull.union(key1D, xyTo1D(row + 1, col));

                }
            }
        }
        if (col > 0) {
            if (check[row][col - 1]) {
                if (!check1DIsFull.connected(key1D, xyTo1D(row, col - 1))) {
                    check1D.union(key1D, xyTo1D(row, col - 1));
                    check1DIsFull.union(key1D, xyTo1D(row, col - 1));
                }
            }
        }
        if (col < check[0].length - 1) {
            if (check[row][col + 1]) {
                if (!check1DIsFull.connected(key1D, xyTo1D(row, col + 1))) {
                    check1D.union(key1D, xyTo1D(row, col + 1));
                    check1DIsFull.union(key1D, xyTo1D(row, col + 1));
                }
            }
        }
        numOpenSites++;
        count++;
    }


    public boolean isOpen(int row, int col) {
        return check[row][col];
    }

    public boolean isFull(int row, int col) {
        return check1DIsFull.connected(topSite, xyTo1D(row, col));
    }

    public int numberOfOpenSites() {
        return numOpenSites;
    }

    public boolean percolates() {
        return check1D.connected(topSite, bottomSite);
    }

    public int xyTo1D(int x, int y) {
        return check[0].length * x + y;
    }

    public static void main(String[] args) {
    }
}

