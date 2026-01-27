package p09_interfaces;

public interface Movable {
    int MAX_SPEED = 200; // implicitly public static final

    void move(int speed);

    default void stop() {
        System.out.println("Stopping.");
    }

    default void cruise(int length){
        for (int i = 0; i < length; i++) {
            this.move(40);
        }
    }

    static boolean isValidSpeed(int speed) {
        return speed >= 0 && speed <= MAX_SPEED;
    }
}
