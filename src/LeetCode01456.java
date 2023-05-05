public class LeetCode01456 {

    public static void main(String[] args) {
        final LeetCode01456 solver = new LeetCode01456();
        Assert.check(3, solver.maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {
        int current = 0;
        int max = 0;
        int first = 0;
        for(int last = k - 1; last < s.length(); ++last) {

            if (first == 0) {
                for(int i = first; i <= last; ++i) {

                    if (isVowel(s.charAt(i))) {
                        ++current;
                    }
                }
                max = current;
            } else {
                if (isVowel(s.charAt(first-1))) {
                    --current;
                }
                if (isVowel(s.charAt(last))) {
                    ++current;
                }
                max = Math.max(current, max);
            }

            ++first;
        }
        return max;
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

}
