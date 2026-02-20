package io;

import model.VitalSignRecord;
import util.ParseUtil;
import util.Validation;

import java.io.BufferedReader;
import java.io.Console;
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

    private static <T extends Comparable<T>> Boolean isNullOrLessThanZero(T value){

        if (value == null){
            return true;
        }

        // nan catching on doubles included
        
        if (((Number) value).doubleValue() < 0 || value instanceof Double && Double.isNaN((Double) value)) {
            return true;
        }


        return false;
    }

    private static final String EXPECTED_HEADER =
            "patient_id,timestamp_iso,hr_bpm,spo2_pct,sbp_mmhg,dbp_mmhg,temp_c";

    public List<VitalSignRecord> read(String path) {
        List<VitalSignRecord> out = new ArrayList<>();

        int valid = 0;
        int skipped = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String header = br.readLine();


            // Step 1: validate header is present and matches EXPECTED_HEADER exactly.
            // Validation.require(...)
            Validation.require(header.equals(EXPECTED_HEADER), "Header does not match expected header");
            System.out.println("Header passed check");


            String line;
            int lineNo = 1; // header is line 1

            while ((line = br.readLine()) != null) {
                lineNo++;

                // Step 1: split line into 7 columns.
                String[] columns = line.split(",");

                // Step 1: validate patient_id non-empty.
                // Step 1: validate timestamp format using Validation.looksLikeIsoLocalDateTime.

                try {
                    Validation.require(columns.length == 7, "column count does not match expected");
                    Validation.require(columns[0].length() > 1, "Patient ID does not match pattern");
                    Validation.looksLikeIsoLocalDateTime(columns[1]);
                } catch (IllegalArgumentException e) {
                    skipped++;
                    System.out.println("SKIP line " + lineNo + ": " + e.getMessage());
                    continue;
                }



                // Step 1: parse numeric values using ParseUtil.parseIntOrNull / parseDoubleOrNull.
                Integer heartrateBPM = ParseUtil.parseIntOrNull(columns[2]);
                Integer oxygenSaturationLevel = ParseUtil.parseIntOrNull(columns[3]);
                Integer sBloodPressure = ParseUtil.parseIntOrNull(columns[4]);
                Integer dBloodPressure = ParseUtil.parseIntOrNull(columns[5]);
                Double temperatureC = ParseUtil.parseDoubleOrNull(columns[6]);

                // Step 1: if invalid, print: SKIP line <n>: <reason> and continue.

                if (isNullOrLessThanZero(heartrateBPM) || isNullOrLessThanZero(oxygenSaturationLevel) || isNullOrLessThanZero(sBloodPressure) || isNullOrLessThanZero(dBloodPressure) || isNullOrLessThanZero(temperatureC)){
                    skipped++;
                    System.out.println("SKIP line " + lineNo + ": numeric values dont match expected");
                    continue;
                }

                // Step 1: if valid, construct VitalSignRecord, add to out, increment valid.
                VitalSignRecord record = new VitalSignRecord(columns[0], columns[1], heartrateBPM, oxygenSaturationLevel, sBloodPressure, dBloodPressure, temperatureC);
                out.add(record);
                valid++;
            }

        } catch (Exception ex) {
            throw new RuntimeException("Failed reading CSV: " + ex.getMessage(), ex);
        }

        System.out.println("Loaded " + valid + " valid rows, skipped " + skipped + ".");
        return out;
    }
}
