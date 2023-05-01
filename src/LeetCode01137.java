import java.util.LinkedList;
import java.util.Queue;

public class LeetCode01137 {

    public static void main(String[] args) {
      final LeetCode01137 solver = new LeetCode01137();
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
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(1);
        queue.add(1);
        queue.add(2);
        for (int i = 4; i <= n; ++i) {
            final int toSub = queue.poll();
            sum -= toSub;

            answer = sum;

            sum += answer;
            queue.add(answer);
        }
        return answer;
    }

}
