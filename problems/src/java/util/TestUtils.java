package util;

public class TestUtils {

    public static void assertTrue(boolean assertion) {
        if (!assertion) {
            throw new AssertionError("Not true!");
        }
    }
}
