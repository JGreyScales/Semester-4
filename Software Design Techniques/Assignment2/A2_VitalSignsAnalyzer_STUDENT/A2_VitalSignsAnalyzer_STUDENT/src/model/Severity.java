package model;

/**
 * Clinical severity for a vital-sign record.
 */
public enum Severity {
    OK,
    WARNING,
    CRITICAL;

    /**
     * Returns the more severe of two severities.
     */
    public static Severity max(Severity a, Severity b) {
        if (a == CRITICAL || b == CRITICAL) return CRITICAL;
        if (a == WARNING || b == WARNING) return WARNING;
        return OK;
    }
}
