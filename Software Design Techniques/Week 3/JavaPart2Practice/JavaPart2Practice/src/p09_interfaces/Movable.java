package p09_interfaces;

public interface Movable {
    int MAX_SPEED = 200; // implicitly public static final

    void move(int speed);

    default void stop() {
        System.out.println("Stopping.");
    }

    static boolean isValidSpeed(int speed) {
        return speed >= 0 && speed <= MAX_SPEED;
    }

    // TODO: EXERCISE 1
    // Add a default method cruise() that calls move() at a safe speed.
}
