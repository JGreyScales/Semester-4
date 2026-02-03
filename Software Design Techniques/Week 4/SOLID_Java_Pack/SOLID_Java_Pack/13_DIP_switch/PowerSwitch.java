public class PowerSwitch {
    private final Switchable device;
    private boolean on = false;

    public PowerSwitch(Switchable device) {
        this.device = device;
    }

    public void press() {
        if (on) device.turnOff();
        else device.turnOn();
        on = !on;
    }
}
