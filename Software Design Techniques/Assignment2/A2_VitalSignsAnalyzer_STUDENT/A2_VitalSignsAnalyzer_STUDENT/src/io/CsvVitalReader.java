package io;

import model.VitalSignRecord;
import util.ParseUtil;
import util.Validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads vital-sign CSV data.
 *
 * Step 1 TODOs:
 * - Validate header exactly
 * - Validate each row (7 columns)
 * - Validate patient_id and timestamp format
 * - Parse numeric fields using wrapper types
 * - Skip invalid rows with required message format
 * - Print final loaded/skipped counts
 */
public class CsvVitalReader {

    private static final String EXPECTED_HEADER =
            "patient_id,timestamp_iso,hr_bpm,spo2_pct,sbp_mmhg,dbp_mmhg,temp_c";

    private static boolean isNullOrLessThanZero(Number value) {
        if (value == null) {
            return true;
        }
        if (value instanceof Double && Double.isNaN((Double) value)) {
            return true;
        }
        return value.doubleValue() < 0;
    }

    public List<VitalSignRecord> read(String path) {
        List<VitalSignRecord> out = new ArrayList<>();

        int valid = 0;
        int skipped = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = br.readLine();

            Validation.require(header != null && header.equals(EXPECTED_HEADER), "Header does not match expected header");

            String line;
            int lineNo = 1; // header is line 1

            while ((line = br.readLine()) != null) {
                lineNo++;

                if (line.trim().isEmpty()) {
                    continue; 
                }

                try {
                    String[] columns = line.split(",", -1);

                    Validation.require(columns.length == 7, "column count does not match expected");

                    Validation.require(columns[0] != null && !columns[0].trim().isEmpty(), "Patient ID does not match pattern");

                    Validation.looksLikeIsoLocalDateTime(columns[1]);

                    Integer heartrateBPM = ParseUtil.parseIntOrNull(columns[2].trim());
                    Integer oxygenSaturationLevel = ParseUtil.parseIntOrNull(columns[3].trim());
                    Integer sBloodPressure = ParseUtil.parseIntOrNull(columns[4].trim());
                    Integer dBloodPressure = ParseUtil.parseIntOrNull(columns[5].trim());
                    Double temperatureC = ParseUtil.parseDoubleOrNull(columns[6].trim());

                    if (isNullOrLessThanZero(heartrateBPM) || 
                        isNullOrLessThanZero(oxygenSaturationLevel) || 
                        isNullOrLessThanZero(sBloodPressure) || 
                        isNullOrLessThanZero(dBloodPressure) || 
                        isNullOrLessThanZero(temperatureC)) {
                        throw new IllegalArgumentException("numeric values dont match expected");
                    }

                    VitalSignRecord record = new VitalSignRecord(
                            columns[0].trim(), columns[1].trim(), heartrateBPM, 
                            oxygenSaturationLevel, sBloodPressure, dBloodPressure, temperatureC
                    );
                    out.add(record);
                    valid++;

                } catch (IllegalArgumentException e) {
                    skipped++;
                    System.out.println("SKIP line " + lineNo + ": " + e.getMessage());
                } catch (Exception e) {
                    skipped++;
                    System.out.println("SKIP line " + lineNo + ": " + e.getMessage());
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException("Failed reading CSV: " + ex.getMessage(), ex);
        }

        System.out.println("Loaded " + valid + " valid rows, skipped " + skipped + ".");
        return out;
    }
}