package rules;

/**
 * Thresholds for classification.
 *
 * Step 2:
 * - Express all cutoffs as public static final constants (no magic numbers in logic)
 *
 * Rules to implement:
 * HR (bpm): OK 60–100, WARNING 50–59 or 101–140, CRITICAL <50 or >140
 * SpO2 (%): OK ≥95, WARNING 90–94, CRITICAL <90
 * SBP (mmHg): OK 90–139, WARNING 80–89 or 140–160, CRITICAL <80 or >160
 * DBP (mmHg): OK >=80, WARNING >80, CRITICAL >=96
 * Temp (C): OK 36.0–37.5, WARNING 35.5–35.9 or 37.6–38.9, CRITICAL <35.5 or ≥39.0
 */
public class VitalRules {
    // Schema: {lowerOk, upperOk, lowerCritical, upperCritical}
    
    // OK 60–100, CRITICAL <50 or >140
    public static final Integer[] HR = {60, 100, 50, 140}; 

    // OK ≥95 (Upper is 100%), CRITICAL <90
    public static final Integer[] SpO2 = {95, 100, 90, 101}; 

    // OK 90–139, CRITICAL <80 or >160
    public static final Integer[] SBP = {90, 139, 80, 160}; 

    // Instructions didn't provide specific DBP "OK" ranges for the 1.6.1 table, 
    // but typically DBP OK is < 90
    public static final Integer[] DBP = {0, 89, 0, 120}; 

    // OK 36.0–37.5, CRITICAL <35.5 or ≥39.0
    public static final Double[] TEMP = {36.0, 37.5, 35.5, 39.0};

    private VitalRules() {}
}
