import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitonicArraySearchTest {

    @Test
    public void searchEndOfArray() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(4, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchStartOfArray() {
        int[] arr = {50, 40, 30, 20, 10};
        int target = 50;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(0, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchPeakOfArray() {
        int[] arr = {10, 20, 30, 20, 10};
        int target = 30;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(2, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchMiddleOfAscendingOfArray() {
        int[] arr = {10, 23, 40, 37, 12};
        int target = 23;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(1, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchMiddleOfDescendingOfArray() {
        int[] arr = {10, 23, 40, 37, 12};
        int target = 37;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(3, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchMiddleOfDescendingOfArrayLong() {
        int[] arr = {10, 23, 24, 45, 60, 70, 40, 37, 12, 8};
        int target = 37;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(7, bitonicArraySearch.getIndexOfTarget());
    }

    @Test
    public void searchMiddleOfAscendingOfArrayLong() {
        int[] arr = {10, 23, 24, 45, 60, 70, 40, 37, 12, 8};
        int target = 23;
        BitonicArraySearch bitonicArraySearch = new BitonicArraySearch(arr, target);
        assertEquals(1, bitonicArraySearch.getIndexOfTarget());
    }

}