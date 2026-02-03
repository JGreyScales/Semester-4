public class Car {
    private final String model;
    private final int year;
    private final int id;

    private static int numberOfCars = 0;

    public static Car of(String model){
        int currentYear = 2026;
        return new Car(model, currentYear);
    }

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
        this.id = ++numberOfCars;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }
    public int getId() { return id; }

    public static int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfCarsLikeInstance() {
        return numberOfCars;
    }

    public static void resetCountter() {
        numberOfCars = 0;
    }
}
