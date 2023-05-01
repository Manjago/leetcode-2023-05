// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
public class LeetCode01491 {
    public double average(int[] salary) {
        int min = salary[0];
        int max = min;
        int acc = min;
        for (int i = 1; i < salary.length; ++i) {
            final int current = salary[i];
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
            acc += current;
        }
        acc -= min;
        acc -= max;
        return ((double)acc) / (salary.length - 2);
    }
}
