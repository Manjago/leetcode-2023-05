import java.util.Arrays;

public class LeetCode01799 {

    public int maxScore(int[] nums) {
        final int memoSize = 1 << nums.length;
        final int[] memo = new int[memoSize];
        Arrays.fill(memo, -1);
        return backtrack(nums, 0, 0, memo);
    }

    public int backtrack(int[] nums, int mask, int pairsPicked, int[] memo) {
        if (2 * pairsPicked == nums.length) {
            return 0;
        }

        if (memo[mask] != -1) {
            return memo[mask];
        }

        int maxScore = 0;

        for (int firstIndex = 0; firstIndex < nums.length; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; ++secondIndex) {

                if (((mask >> firstIndex) & 1) == 1 || ((mask >> secondIndex) & 1) == 1) {
                    continue;
                }

               final int newMask = mask | 1 << firstIndex | 1 << secondIndex;

                final int currScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                final int remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);

                maxScore = Math.max(maxScore, currScore + remainingScore);
            }
        }

        memo[mask] = maxScore;
        return maxScore;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
