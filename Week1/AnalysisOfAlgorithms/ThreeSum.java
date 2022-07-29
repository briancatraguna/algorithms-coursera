import java.util.*;

class ThreeSum {
    public boolean threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Integer> integerHashed = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            integerHashed.add(nums[i]);
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
        int target = 0;
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(nums, target));
    }
}

