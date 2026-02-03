Goal: subtypes must be substitutable for their base types.

1) In the Bird example, explain why adding fly() to Bird would violate LSP for Penguin.
   What design was used instead?

2) Fix the Rectangle/Square modeling by redesigning the abstraction:
   Option A: remove setters (make shapes immutable)
   Option B: separate interfaces (e.g., ResizableRectangle vs Square)
   Implement one option and update Main accordingly.

3) Write 2-3 "contract rules" (pre/post conditions) for RectangleLike that a subtype must preserve.
