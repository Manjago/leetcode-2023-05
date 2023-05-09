import java.util.Objects;

public final class Assert {
    private Assert() {
        // mandatory for utility class
    }
    public static void check(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Expected " + expected + ", actual " + actual);
        }
    }
    public static void check(String expected, String actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Expected " + expected + ", actual " + actual);
        }
    }
}
