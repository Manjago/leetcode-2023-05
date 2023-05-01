public final class Assert {
    private Assert() {
        // mandatory for utility class
    }
    public static void check(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected " + expected + ", actual " + actual);
        }
    }
}
