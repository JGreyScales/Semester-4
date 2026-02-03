Goal: understand why wrappers exist and where they can bite you.

1) Create a List<Integer> that contains a null.
   Loop and unbox to int. What happens? Explain.
Cannot invoke "java.lang.Integer.intValue()" because "<local4>" is null

2) Write a method safeAdd(List<Integer> xs) that skips nulls.
   Add unit-like checks in Main (no JUnit needed).

3) Explain (short paragraph) why collections and generics use wrapper classes instead of primitives.

It allows them to be more diverse in their functionality. They rarely need to actually know the content of what they are storing, they just need to know the size of it and thats it. So it doesnt matter what they are storing, so making it generic reduces repeated code