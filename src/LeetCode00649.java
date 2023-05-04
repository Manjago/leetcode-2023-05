import java.util.LinkedList;
import java.util.Queue;

public class LeetCode00649 {
    public String predictPartyVictory(String senate) {

        final Queue<Character> queue = new LinkedList<>();
        int radiantCount = 0;
        int direCount = 0;
        int radiantBanned = 0;
        int direBanned = 0;

        for(int i = 0; i < senate.length(); ++i) {
            final char c = senate.charAt(i);
            switch(c) {
                case 'R':
                    ++radiantCount;
                    break;
                case 'D'  :
                    ++direCount;
                    break;
                default:
                    throw new IllegalArgumentException("Bad input " + c);
            }
            queue.add(c);
        }

        while(!queue.isEmpty()) {
            final char c = queue.poll();

            switch(c) {
                case 'R':
                    if (radiantBanned > 0) {
                        --radiantBanned;
                        --radiantCount;
                        continue;
                    } else if (direCount == 0) {
                        return "Radiant";
                    } else {
                        ++direBanned;
                        queue.add(c);
                    }
                    break;
                case 'D':
                    if (direBanned > 0) {
                        --direBanned;
                        --direCount;
                        continue;
                    } else if (radiantCount == 0) {
                        return "Dire";
                    } else {
                        ++radiantBanned;
                        queue.add(c);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Bad input " + c);
            }

        }

        throw new IllegalStateException("Bad logic");

    }
}
