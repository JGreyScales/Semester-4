public class Car {
    private final String model;
    private final int year;
    private final int id;

    private static int numberOfCars = 0;

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
}
