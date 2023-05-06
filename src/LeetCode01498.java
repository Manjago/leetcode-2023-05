import java.util.Arrays;

public class LeetCode01498 {

    public static void main(String[] args) {
        final LeetCode01498 solver = new LeetCode01498();
        Assert.check(4, solver.numSubseq(new int[]{3, 5, 6, 7}, 9));
        Assert.check(6, solver.numSubseq(new int[]{3, 3, 6, 8}, 10));
        Assert.check(61, solver.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        final int n = nums.length;
        final int modulo = 1_000_000_007;

        // 9 [3,5,6] -> [3], [3, 5], [3, 5, 6], [3, 6] - 4
        // 9 [3,5] -> [3], [3, 5] - 2
        // 9 [3] -> [3] - 1
        final int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % modulo;
        }

        int left = 0;
        int right = n - 1;
        int answer = 0;
        while (left <= right) {
            final int pretender = nums[left] + nums[right];
            if (pretender <= target) {
                answer = answer + power[right - left];
                answer = answer % modulo;
                ++left;
            } else {
                --right;
            }
        }

        return answer;
    }

}
