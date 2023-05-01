// Beats 97.23%
public class LeetCode01137_3 {

    public static void main(String[] args) {
      final LeetCode01137_3 solver = new LeetCode01137_3();
      Assert.check(0, solver.tribonacci(0));
      Assert.check(1, solver.tribonacci(1));
      Assert.check(1, solver.tribonacci(2));
      Assert.check(2, solver.tribonacci(3));
      Assert.check(4, solver.tribonacci(4));
      Assert.check(7, solver.tribonacci(5));
      Assert.check(13, solver.tribonacci(6));
      Assert.check(24, solver.tribonacci(7));
    }

/*
(0) = 0
(1) = 1
(2) = 1
(3) = 0(0) + 1(1) + 1(2) = 2
(4) = 1(1) + 1(2) + 2(3) = 4
(5) = 1(2) + 2(3) + 4(4) = 7
(6) = 2(3) + 4(4) + 7(5) = 13
(7) = 4(4) + 7(5) + 13(6) = 24
*/
    public int tribonacci(int n) {

        final int[] data = new int[]{0, 1, 1, 2};
        int current = 0;
        int next = 0;

        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
        }
        int sum = 4;
        int answer = sum;
        for (int i = 4; i <= n; ++i) {
            final int toSub = data[current];
            ++current;
            if (current >= 4) {
                current = 0;
            }

            sum -= toSub;

            answer = sum;

            sum += answer;

            data[next] = answer;
            ++next;
            if (next >= 4) {
                next = 0;
            }
        }
        return answer;
    }

}
