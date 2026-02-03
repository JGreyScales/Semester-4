Goal: decide when to use an abstract class vs an interface (as in the slides).

1) Add an interface Taxable with method double taxFor(double amount).
   Make one processor implement it and apply tax inside pay() WITHOUT changing PaymentProcessor.pay().
   Hint: use composition (a helper) or override validate/doPay carefully.

2) Create a new processor type (e.g., InteracProcessor) that shares most logic.
   Decide: abstract class or interface? Justify in comments.

3) Sketch a small UML class diagram (text is fine) showing:
   PaymentProcessor, Refundable, and at least 2 concrete processors.
