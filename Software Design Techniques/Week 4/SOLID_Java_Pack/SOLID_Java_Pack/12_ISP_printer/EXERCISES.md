Goal: clients should not depend on methods they do not use.

1) Create a BadPrinter interface with print/fax/scan/email.
   Make NormalPrinter implement it with empty or throwing methods.
   Identify the smells.

2) Add a PhotoPrinter that can print + email but cannot fax or scan.
   Model it using ISP-style interfaces (not BadPrinter).

3) Sketch a UML diagram showing how ISP creates smaller, role-based interfaces.
