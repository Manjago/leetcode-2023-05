public class LeetCode02140 {
    long[] dp;

    public long mostPoints(int[][] questions) {
        final int n = questions.length;
        dp = new long[n];
        return dfs(questions, 0);
    }

    private long dfs(int[][] questions, int i) {
        if (i >= questions.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        }
        final long points = questions[i][0];
        final int skip = questions[i][1];

        final long skipIt = points + dfs(questions, i + skip + 1);
        final long solveIt = dfs(questions, i + 1);
        dp[i] = Math.max(skipIt, solveIt);
        return dp[i];
    }

}
