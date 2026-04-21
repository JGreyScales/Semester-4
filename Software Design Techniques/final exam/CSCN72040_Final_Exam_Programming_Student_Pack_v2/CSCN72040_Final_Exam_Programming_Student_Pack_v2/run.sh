#!/usr/bin/env bash
set -e
rm -rf bin
mkdir -p bin
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt
java -cp bin exam.app.Main
