// https://leetcode.com/problems/sign-of-the-product-of-an-array/
public class LeetCode01822 {
    public int arraySign(int[] nums) {
        int sign = mySign(nums[0]);
        if (sign == 0) {
            return 0;
        }

        for(int i = 1; i < nums.length; ++i) {
            sign = sign * mySign(nums[i]);
            if (sign == 0) {
                return 0;
            }
        }

        return sign;

    }

    private static int mySign(int value) {
        if (value == 0) {
            return 0;
        } else if (value > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
