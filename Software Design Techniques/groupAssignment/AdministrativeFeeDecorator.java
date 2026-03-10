public class AdministrativeFeeDecorator implements Appointment {
    protected Appointment appointment;

    public  AdministrativeFeeDecorator(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost() + 10.00;
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
