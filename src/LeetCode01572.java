public class LeetCode01572 {
    public int diagonalSum(int[][] mat) {
        final int n = mat.length;
        int answer = 0;
        for(int x = 0; x < n; ++x) {
            answer += mat[x][x];
        }
        for(int x = n -1; x >=0 ; --x) {
            final int y = n - 1 - x;
            if (x == y) {
                continue;
            }
            answer += mat[y][x];
        }
        return answer;
    }
}
