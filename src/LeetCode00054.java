import java.util.ArrayList;
import java.util.List;

public class LeetCode00054 {

    public static void main(String[] args) {
        final LeetCode00054 solver = new LeetCode00054();
        System.out.println(solver.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
    }

    private static final int VISITED = -101;
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> answer = new ArrayList<>();
        final int yMax = matrix.length;
        final int xMax = matrix[0].length;
        final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int toVisit = xMax * yMax;

        int x = 0;
        int y = 0;
        answer.add(matrix[y][x]);
        matrix[y][x] = VISITED;
        --toVisit;

        while(toVisit > 0) {
            final int nextX = x + directions[directionIndex][1];
            final int nextY = y + directions[directionIndex][0];

            if (
                    (nextX < 0) ||
                            (nextY < 0) ||
                            (nextX > (xMax - 1)) ||
                            (nextY > (yMax - 1)) ||
                            (matrix[nextY][nextX] == VISITED)
            ) {
                ++directionIndex;
                directionIndex = directionIndex % 4;
            } else {
                y = nextY;
                x = nextX;
                answer.add(matrix[y][x]);
                matrix[y][x] = VISITED;
                --toVisit;
            }

        }
        return answer;
    }
}
