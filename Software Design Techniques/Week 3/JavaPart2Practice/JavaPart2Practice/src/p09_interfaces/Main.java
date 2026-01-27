package p09_interfaces;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        int maxSpeed = Config.getInt("demo.maxSpeed", Movable.MAX_SPEED);
        System.out.println("Configured maxSpeed (demo): " + maxSpeed);

        Bmw car = new Bmw();
        car.move(120);
        car.stop();

        // TODO: EXERCISE 2
        // Try car.move(maxSpeed + 10) and observe validation.
    }
}

