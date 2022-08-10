import edu.princeton.cs.algs4.Shell;

/**
 * Question 1
 * Intersection of two sets.
 * Given two arrays a[] and b[], each containing nn distinct 2D points in the plane, design a subquadratic algorithm
 * to count the number of points that are contained both in array a[] and array b[].
 */
public class Points2D implements Comparable<Points2D> {

    private int x;
    private int y;

    public Points2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Points2D that) {
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        if (this.y < that.y) return -1;
        if (this.y > that.y) return -1;
        return 0;
    }

    public static int intersection(Points2D[] a, Points2D[] b) {
        Shell.sort(a);
        Shell.sort(b);

        int i = 0;
        int j = 0;
        int count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                count++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
