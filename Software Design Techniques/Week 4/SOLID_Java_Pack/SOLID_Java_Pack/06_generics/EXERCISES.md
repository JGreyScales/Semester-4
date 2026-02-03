Goal: apply generics (type parameters) like in the slide.

1) Add a method in Box: boolean hasSameTypeAs(Box<?> other)
   Hint: you cannot compare generic types at runtime directly. Think about alternative signals.

2) Write a static generic utility method:
   <T> void copy(Box<T> from, Box<T> to)

3) Why can't you do Box<int>? Write a brief explanation referencing primitives vs wrappers.
// int is not a Wrapper, it is a raw primitive type.
Runtime generics can only occur with wrappers as they have behaviour to handle it.