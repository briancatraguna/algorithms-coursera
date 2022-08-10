import edu.princeton.cs.algs4.Shell;

import java.util.Objects;

/**
 * Question 2
 * Permutation.
 * Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a permutation
 * of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
 */
public class Permutation {

    public static boolean isPermutation(Integer[] a, Integer[] b) {
        if (a.length != b.length) return false;
        Shell.sort(a);
        Shell.sort(b);

        for (int i = 0; i < a.length; i ++) {
            if (!Objects.equals(a[i], b[i])) return false;
        }
        return true;
    }
}
