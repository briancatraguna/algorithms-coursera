import java.util.*;

class ThreeSum {

    private final int[] nums;
    private final int target;

    public ThreeSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }
    public boolean hasThreeSum() {
        Arrays.sort(nums);
        HashSet<Integer> integerHashed = new HashSet<>();
        for (int num : nums) {
            integerHashed.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int value = target - nums[i] - nums[j];
                boolean hasValue = integerHashed.contains(value);
                if (hasValue) {
                    int k = List.of(nums).indexOf(value);
                    if (i != j && i != k && j!= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 10;
        ThreeSum solution = new ThreeSum(nums, target);
        System.out.println(solution.hasThreeSum());
    }
}

