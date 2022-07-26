import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;

    private final WeightedQuickUnionUF sites;

    private final boolean[] openedSites;

    private int openedSitesCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        int topIndex = 0;
        int bottomIndex = n * n + 1;

        this.n = n;
        this.sites = new WeightedQuickUnionUF(n * n + 2);

        this.openedSites = new boolean[n * n + 2];
        for (int i = 0; i < (n * n + 2); i ++) {
            this.openedSites[i] = false;
        }
        this.openedSites[topIndex] = true;
        this.openedSites[bottomIndex] = true;
        this.openedSitesCount = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateRowCol(row, col);
        this.openedSites[getId(row, col)] = true;
        getSurroundingOpenSites(row, col);
        this.openedSitesCount++;
    }

    private void getSurroundingOpenSites(int row, int col) {
        int id = getId(row, col);
        //top
        if (row > 1) {
            if (isOpen(row - 1, col)) {
                this.sites.union(id,(getId(row - 1, col)));
            }
        }
        //bottom
        if (row < n) {
            if (isOpen(row + 1, col)) {
                this.sites.union(id, (getId(row + 1, col)));
            }
        }
        //left
        if (col > 1) {
            if (isOpen(row, col - 1)) {
                this.sites.union(id,(getId(row, col - 1)));
            }
        }
        //right
        if (col < n) {
            if (isOpen(row, col + 1)) {
                this.sites.union(id, (getId(row, col + 1)));
            }
        }

        //virtual top
        if (row == 1) {
            this.sites.union(id,(0));
        }

        if (row == n) {
            this.sites.union(id, (n * n + 1));
        }
    }

    private int getId(int row, int col) {
        int initialRowMultiplier = n * (row - 1);
        return (initialRowMultiplier) + (col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateRowCol(row, col);
        return this.openedSites[getId(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateRowCol(row, col);
        return isConnected(getId(row, col));
    }

    private boolean isConnected(int q) {
        return this.sites.find(0) == this.sites.find(q);
    }

    private void validateRowCol(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    public int numberOfOpenSites() {
        return this.openedSitesCount;
    }

    public boolean percolates() {
        return isConnected(n * n + 1);
    }

    public static void main(String[] args) {
        Percolation myPercolation = new Percolation(3);

        myPercolation.open(1, 1);
        myPercolation.open(2, 1);
        myPercolation.open(2, 2);
        myPercolation.open(2, 3);
        myPercolation.open(3, 3);
        StdOut.println(myPercolation.percolates());
        StdOut.println(myPercolation.numberOfOpenSites());
    }

}
