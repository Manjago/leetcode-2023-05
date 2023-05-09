import java.util.Arrays;

public class LeetCode01964 {

    public static void main(String[] args) {
        final LeetCode01964 solver = new LeetCode01964();
        Assert.check("[1, 2, 3, 3]", Arrays.toString(solver.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2})));
        Assert.check("[1, 2, 1]", Arrays.toString(solver.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1})));
        Assert.check("[1, 1, 2, 3, 2, 2]", Arrays.toString(solver.longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})));
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;
        final int[] answer = new int[n];

        int auxLen = 0;
        final int[] aux = new int[n];

        for (int i = 0; i < n; ++i) {
            final int height = obstacles[i];

            int index = binarySearch(aux, height, auxLen);
            if (index == auxLen) {
                auxLen++;
            }

            aux[index++] = height;
            answer[i] = index;
        }
        return answer;
    }


    private int binarySearch(int[] aux, int target, int right) {
        if (right == 0) {
            return 0;
        }
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (aux[mid] <= target) {
                left = mid + 1;
            } else
                right = mid;
        }
        return left;
    }
}
