#!/usr/bin/env bash
set -euo pipefail

STEP=${1:-}
if [[ -z "$STEP" ]]; then
  echo "Usage: ./run_step.sh step03"
  exit 1
fi

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC_DIR="$ROOT_DIR/src/main/java"
OUT_DIR="$ROOT_DIR/out"

rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

# Compile all main sources
find "$SRC_DIR" -name "*.java" > "$OUT_DIR/sources.txt"
javac -encoding UTF-8 -d "$OUT_DIR" @"$OUT_DIR/sources.txt"

# Run the selected demo
java -cp "$OUT_DIR" com.designtechniques.part1.runner.MainRunner "$STEP"
