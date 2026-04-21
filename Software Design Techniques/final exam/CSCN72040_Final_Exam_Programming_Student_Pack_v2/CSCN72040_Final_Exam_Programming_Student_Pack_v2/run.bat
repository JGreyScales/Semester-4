@echo off
setlocal
if exist bin rmdir /s /q bin
mkdir bin
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
if errorlevel 1 (
    echo Compilation failed.
    del sources.txt
    exit /b 1
)
del sources.txt
java -cp bin exam.app.Main
endlocal
