public class Main {
    public static void main(String[] args) {
        Appointment appointment = 
            new AdministrativeFeeDecorator(
                new InsuranceCoverageDecorator(
                    new Consultation()));

        System.out.println(appointment.getCost());
        System.out.println(appointment.getDescription()); 
    }
}