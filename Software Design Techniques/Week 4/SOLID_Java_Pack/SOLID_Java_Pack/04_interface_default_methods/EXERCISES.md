Goal: use default methods to evolve an interface.

1) Add a default method error(String message) that prefixes 'ERROR:'.
2) Create a FileLogger that writes to a file (keep it simple, append mode).
3) Explain in comments why adding an abstract method to Logger would break existing implementations, but adding a default method does not.

Adding an abstract to logger wont work, because then it would need to be re-implimented into filelogger and consolelogger, when it instead can just be managed at the parent level