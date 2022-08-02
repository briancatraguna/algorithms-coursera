public class GFG {

    /**
     * @param n = number of eggs
     * @param k = number of floors
     * @return minimum number of attempts to guarantee the highest floor in which the egg will break
     */
    static int eggDrop(int n, int k) {
        /**
         * if there are no floors, then
         * no trials needed, or if there is one floor,
         * one trial needed
         */
        if (k == 1 || k == 0) {
            return k;
        }

        /**
         *  we need k trials for one egg
         *  and k floors
         */
        if (n == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1),
                    eggDrop(n, k - x));
            if (res < min) {
                min = res;
            }
        }
        return min + 1;
    }
}
