import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int numberOfTrials;

    private final double[] x;

    // perform independent trials on an n by n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        double totalNumberOfSites = n * n;
        this.numberOfTrials = trials;
        this.x = new double[trials];
        for (int trial = 0; trial < trials; trial++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int randomRow = StdRandom.uniform(n) + 1;
                int randomCol = StdRandom.uniform(n) + 1;
                percolation.open(randomRow, randomCol);
            }
            double numberOfOpenSites = percolation.numberOfOpenSites();
            double percolationThreshold = numberOfOpenSites / totalNumberOfSites;
            x[trial] = percolationThreshold;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(this.x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(this.x);
    }


    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        return mean - ((1.96 * stddev()) / Math.sqrt(this.numberOfTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        return mean + ((1.96 * stddev()) / Math.sqrt(this.numberOfTrials));
    }

    private double[] confidenceInterval() {
        double[] result = new double[2];
        result[0] = confidenceLo();
        result[1] = confidenceHi();
        return result;
    }

    // test client
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + "["
                + stats.confidenceLo() + ", "
                + stats.confidenceHi() + "]");
    }

}
