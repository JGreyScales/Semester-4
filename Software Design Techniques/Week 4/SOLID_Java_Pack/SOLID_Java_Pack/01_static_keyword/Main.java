public class Main {
    public static void main(String[] args) {
        System.out.println("== static keyword demo ==");

        Car c1 = new Car("BMW", 2023);
        Car c2 = new Car("Mazda", 2023);
        Car c3 = new Car("Toyota", 2023);

        System.out.println("Cars created: " + Car.getNumberOfCars());

        // Accessing statics via instance works, but is discouraged because it looks like instance state.
        System.out.println("Via instance (discouraged style): " + c1.getNumberOfCarsLikeInstance());
    }
}
