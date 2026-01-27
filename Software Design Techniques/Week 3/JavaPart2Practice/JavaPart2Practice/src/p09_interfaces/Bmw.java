package p09_interfaces;

public class Bmw implements Movable {
    private int currentSpeed = 0;

    @Override
    public void move(int speed) {
        if (!Movable.isValidSpeed(speed)) {
            System.out.println("Invalid speed: " + speed);
            return;
        }
        currentSpeed = speed;
        System.out.println("BMW moving at " + currentSpeed);
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}

