package util;

/**
 * Small validation helpers for the assignment.
 */
public class Validation {

    /**
     * Throws IllegalArgumentException if condition is false.
     */
    public static void require(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
    }

    /**
     * Minimal timestamp format check: YYYY-MM-DDTHH:MM:SS
     * This is intentionally light-weight for the assignment.
     */
    public static boolean looksLikeIsoLocalDateTime(String s) {
        if (s == null) return false;
        if (s.length() != 19) return false;
        return s.charAt(4) == '-' && s.charAt(7) == '-' && s.charAt(10) == 'T'
                && s.charAt(13) == ':' && s.charAt(16) == ':';
    }

    private Validation() {}
}
