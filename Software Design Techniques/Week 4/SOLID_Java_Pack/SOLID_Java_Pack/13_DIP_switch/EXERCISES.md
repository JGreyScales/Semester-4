Goal: high-level modules should not depend on low-level modules; both depend on abstractions.

1) Write a BadPowerSwitch class that directly depends on TV (has a TV field).
   Try to reuse it with Computer. What changes are required?

2) Add a new device (e.g., PrinterDevice) that implements Switchable.
   Confirm you do not need to modify PowerSwitch.

3) Extend PowerSwitch with an optional Logger dependency (interface).
   Apply DIP twice: PowerSwitch depends on Logger abstraction, not ConsoleLogger.
