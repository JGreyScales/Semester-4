Goal: practice class-level (static) state and methods.

1) Add a static method resetCounter() that resets numberOfCars to 0.
   Then demonstrate it in Main and explain what happens to existing car ids.

2) Add a static factory method of(String model) that defaults year to the current year.
   Keep it simple (hardcode current year if you want).

3) Discussion: when is static a bad idea? Provide one example of hidden coupling.
children and multi-instance uses are coupled through 'shared' resources