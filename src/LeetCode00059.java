import java.util.Arrays;

public class LeetCode00059 {

    public static void main(String[] args) {
        final LeetCode00059 solver = new LeetCode00059();
        System.out.println(Arrays.deepToString(solver.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solver.generateMatrix(1)));
    }

    public int[][] generateMatrix(int n) {
        final int[][] matrix = new int[n][n];
        final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int toVisit = n * n;

        int x = 0;
        int y = 0;
        int current = 1;
        matrix[y][x] = current++;
        --toVisit;

        while(toVisit > 0) {
            final int nextX = x + directions[directionIndex][1];
            final int nextY = y + directions[directionIndex][0];

            if (
                    (nextX < 0) ||
                            (nextY < 0) ||
                            (nextX > (n - 1)) ||
                            (nextY > (n - 1)) ||
                            (matrix[nextY][nextX] != 0)
            ) {
                ++directionIndex;
                directionIndex = directionIndex % 4;
            } else {
                y = nextY;
                x = nextX;
                matrix[y][x] = current++;
                --toVisit;
            }
        }

        return matrix;
    }
}
