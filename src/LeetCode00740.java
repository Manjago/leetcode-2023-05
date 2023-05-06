import java.util.HashMap;
import java.util.Map;

public class LeetCode00740 {

    public static void main(String[] args) {
        Assert.check(6, new LeetCode00740().deleteAndEarn(new int[]{3, 4, 2}));
        Assert.check(9, new LeetCode00740().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        Assert.check(4, new LeetCode00740().deleteAndEarn(new int[]{3, 1}));
    }


    final Map<Integer, Integer> data = new HashMap<>();
    final Map<Integer, Integer> cache = new HashMap<>();

    public int deleteAndEarn(int[] nums) {

        int maxKey = -1;
        for (int i = 0; i < nums.length; i++) {
            final int item = nums[i];
            if (data.containsKey(item)) {
                data.put(item, data.get(item) + 1);
            } else {
                data.put(item, 1);
            }
            if (item > maxKey) {
                maxKey = item;
            }
        }

        return earnMax(maxKey);
    }

    private int earnMax(int n) {

        switch (n) {
            case 0:
                return 0;
            case 1:
                return data.getOrDefault(1, 0);
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        final int gain = data.getOrDefault(n, 0) * n;
        int answer = Math.max(gain + earnMax(n - 2), earnMax(n - 1));
        cache.put(n, answer);
        return answer;
    }

}
