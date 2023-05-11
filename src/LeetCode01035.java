import java.util.Arrays;

public class LeetCode01035 {

    int[] data1;
    int[] data2;
    int[][] memo;

    public static void main(String[] args) {
        Assert.check(2, new LeetCode01035().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        Assert.check(3, new LeetCode01035().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        Assert.check(2, new LeetCode01035().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        data1 = nums1;
        data2 = nums2;
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        memo = new int[n1][n2];
        return find(n1 - 1, n2 - 1);
    }

    private int find(int index1, int index2) {
        if ((index1 < 0) || (index2 < 0)) {
            return 0;
        }

        int answer = load(index1, index2);
        if (answer >= 0) {
            return answer;
        }

        final int result;
        if (data1[index1] == data2[index2]) {
            result = 1 + find(index1 - 1, index2 - 1);
        } else {
            result = Math.max(find(index1, index2 - 1), find(index1 - 1, index2));
        }
        store(index1, index2, result);
        return result;
    }

    private void store(int index1, int index2, int value) {
        memo[index1][index2] = value + 1;
    }

    private int load(int index1, int index2) {
        return memo[index1][index2] - 1;
    }
}
