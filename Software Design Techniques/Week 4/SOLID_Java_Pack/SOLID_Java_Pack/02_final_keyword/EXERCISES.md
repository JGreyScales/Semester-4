Goal: understand final on variables, methods, and classes.

1) Create a new class Device (NOT final). Add a final method serialNumber().
   Attempt to override it in a subclass and observe the compiler error.

2) Explain (in comments) the difference between:
   - final primitive variable - the value is fixed forever
   - final reference variable - the value can be modified through methods, but the reference pointer cannot be modified
   Use StringBuilder as the example.

3) When is 'final class' useful? Give one real-world reason.
final class is useful for statuses, protected references, memory safety and best pratices

for example, in our case strings should be inmuttable and cloned on modification to adhere to the best pratice for using and handling strings in memory. therefore restricting direct modification of the string reference is ideal for protecting this behaviour.