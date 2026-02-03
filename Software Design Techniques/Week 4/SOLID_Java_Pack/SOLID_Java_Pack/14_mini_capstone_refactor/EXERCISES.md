Goal: practice spotting violations and refactoring.

Part A: Identify violations (in comments)
1) In OrderServiceBad, list at least 3 SOLID violations (name the principle and why).

Part B: Refactor incrementally
2) In OrderParser, remove if/else by introducing:
   - a ShapeFactory interface
   - one factory per shape type
   - a registry Map<String, ShapeFactory>
   Then you can add new shapes without editing parse().

3) Introduce DIP for output:
   - define an interface ReceiptOutput (e.g., printLine)
   - implement ConsoleReceiptOutput
   - make ReceiptPrinter depend on ReceiptOutput (constructor injection)

4) Add a new shape type (Triangle) with minimal changes.
