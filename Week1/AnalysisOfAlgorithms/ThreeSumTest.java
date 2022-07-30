import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ThreeSumTest {

    @Test
    public void hasNoThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 10;
        ThreeSum threeSum = new ThreeSum(nums, target);
        assertFalse(threeSum.hasThreeSum());
    }

    @Test
    public void hasThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 3;
        ThreeSum threeSum = new ThreeSum(nums, target);
        assertTrue(threeSum.hasThreeSum());
    }

}