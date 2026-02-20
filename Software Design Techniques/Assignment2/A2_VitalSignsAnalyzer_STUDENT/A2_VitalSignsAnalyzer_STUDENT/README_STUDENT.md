# Assignment A2 — Vital Signs Log Analyzer (Java)

## What this starter pack contains
This project is a *starter skeleton*. It compiles only after you complete the TODOs.
You must implement Steps 1–4 in order. Do NOT delete the package structure.

## How we run your program

// from src
```bash
javac -d ../out *.java 
```

// from project root
```bash
java -cp out Main data/vitals_sample.csv
```


If your shell does not support `**`, use PowerShell:

```powershell
mkdir out -ea 0
Get-ChildItem -Recurse -Filter *.java src | % { javac -d out $_.FullName }
java -cp out Main data/vitals_sample.csv
```

## Mandatory input
You must use the provided CSV file unchanged:
`data/vitals_sample.csv`

## Step-by-step TODOs (what you must implement)

### Step 1 — CSV parsing + validation (io/CsvVitalReader.java)
You must:
1) validate the header exactly,
2) parse each row (7 columns),
3) validate patient_id non-empty,
4) validate timestamp format (YYYY-MM-DDTHH:MM:SS),
5) parse numeric fields using wrapper types (Integer, Double),
6) skip invalid rows and print: `SKIP line <n>: <reason>`,
7) print: `Loaded <validCount> valid rows, skipped <skipCount>.`

### Step 2 — Classification rules + per-patient counts (rules/VitalRules.java, rules/VitalClassifier.java)
You must:
1) express all thresholds as `public static final` constants,
2) implement per-vital classification methods,
3) compute overall severity as the maximum across vitals,
4) aggregate OK/WARNING/CRITICAL counts per patient.

Required correctness check for sample CSV (must match exactly):

patient_id,OK,WARNING,CRITICAL
P001,1,1,1
P002,2,1,0
P003,1,1,1

### Step 3 — Per-patient statistics + generics (stats/PatientSummary.java, stats/StatsUtil.java)
You must compute per patient:
- records count
- mean HR
- min SpO2
- max Temp
- percent non-OK (WARNING or CRITICAL)

You must implement and use at least one generic method or generic class (StatsUtil provides a placeholder).

Expected sample statistics (acceptable rounding error <= 0.01):

P001: records=3 mean_hr=75.67 min_spo2=89 max_temp=37.60 non_ok_pct=66.67
P002: records=3 mean_hr=96.00 min_spo2=92 max_temp=38.50 non_ok_pct=33.33
P003: records=3 mean_hr=105.00 min_spo2=85 max_temp=39.20 non_ok_pct=66.67

### Step 4 — Clean design + export out/report.csv (report/*)
You must:
1) keep Main as orchestration only,
2) use an interface with a default method (ReportFormatter),
3) print a readable report,
4) write `out/report.csv` ordered by patient_id.

Expected out/report.csv content for sample input (order required):

patient_id,ok,warning,critical,records,mean_hr,min_spo2,max_temp,non_ok_pct
P001,1,1,1,3,75.67,89,37.60,66.67
P002,2,1,0,3,96.00,92,38.50,33.33
P003,1,1,1,3,105.00,85,39.20,66.67

## What you must NOT do
- Do not hard-code answers for the sample file.
- Do not move logic into Main.
- Do not remove packages or rename files.
