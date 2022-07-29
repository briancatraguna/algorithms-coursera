import java.util.Arrays;

public class BitonicArraySearch {

    private final int[] arr;
    private final int target;

    private boolean decreasingIsEmpty = false;
    private boolean increasingIsEmpty = false;

    public BitonicArraySearch(int[] arr, int target) {
        this.arr = arr;
        this.target = target;
    }

    private int getPeakIndex() {
        int mid = arr.length / 2;
        int low = 0;
        int high = arr.length - 1;
        while (!(arr[mid + 1] < arr[mid] && arr[mid - 1] < arr[mid])) {
            if (arr[mid + 1] > arr[mid]) {
                low = mid + 1;
            }
            if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            }
            mid = (low + high) / 2;
            if (mid == 0) {
                increasingIsEmpty = true;
                break;
            }
            if (mid == arr.length - 1) {
                decreasingIsEmpty = true;
                break;
            }
        }
        return mid;
    }

    public int getIndexOfTarget() {
        if (arr[getPeakIndex()] == target) {
            return getPeakIndex();
        }
        if (!increasingIsEmpty) {
            int targetIndexFromAscending = getTargetIndexFromAscending();
            if (arr[targetIndexFromAscending] == target) {
                return targetIndexFromAscending;
            }
        }
        if (!decreasingIsEmpty) {
            int targetIndexFromDecreasing = getTargetIndexFromDescending();
            if (arr[targetIndexFromDecreasing] == target) {
                return targetIndexFromDecreasing;
            }
        }
        return -1;
    }

    private int getTargetIndexFromAscending() {
        int startIndex = 0;
        int endIndex = getPeakIndex();
        int[] ascendingArr = Arrays.copyOfRange(arr, startIndex, endIndex);
        int low = 0;
        int high = ascendingArr.length - 1;
        int closestToTarget = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ascendingArr[mid] > target) {
                high = mid - 1;
            } else if (ascendingArr[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
            closestToTarget = mid;
        }
        return closestToTarget;
    }

    private int getTargetIndexFromDescending() {
        int startIndex = getPeakIndex() + 1;
        int endIndex = arr.length;
        int[] descendingArr = Arrays.copyOfRange(arr, startIndex, endIndex);
        int low = 0;
        int high = descendingArr.length - 1;
        int closestToTarget = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (descendingArr[mid] > target) {
                low = mid + 1;
            } else if (descendingArr[mid] < target) {
                high = mid - 1;
            } else {
                return mid + getPeakIndex() + 1;
            }
            closestToTarget = mid;
        }
        return closestToTarget;
    }
}
