Java Programming Part-2 Practice (Eclipse-friendly, no Maven)

How to run (Eclipse)
1) File -> Import -> Existing Projects into Workspace
2) Select the folder: JavaPart2Practice
3) Ensure the project uses a JDK (Project -> Properties -> Java Build Path)
4) Expand src/ and run any package's Main.java allowing you to practice one topic at a time.

How to run (command line, optional)
From the project root:
  javac -d out src/**/**/*.java
  java -cp out p01_hello_packages.Main

Config
This project avoids CLI args. If a demo needs values, it reads them from:
  app.properties (project root)

Topics covered (aligned to the provided Part-2 slides)
Packages, classes/objects, access modifiers, inheritance, Object/toString,
Strings, static/final, abstract classes, interfaces (incl. default/static),
wrapper classes, generics, arrays vs List vs ArrayList.

Exercises
Look for TODO: EXERCISE markers inside the code.
