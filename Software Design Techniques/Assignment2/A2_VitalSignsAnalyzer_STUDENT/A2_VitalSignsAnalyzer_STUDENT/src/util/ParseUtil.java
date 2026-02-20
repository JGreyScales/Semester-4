package util;

/**
 * Parsing helpers that use wrapper types (Integer, Double) as required by the assignment.
 */
public class ParseUtil {

    public static Integer parseIntOrNull(String s) {
        try { return Integer.valueOf(s.trim()); }
        catch (Exception ex) { return null; }
    }

    public static Double parseDoubleOrNull(String s) {
        try { return Double.valueOf(s.trim()); }
        catch (Exception ex) { return null; }
    }

    private ParseUtil() {}
}
