public class AppointmentDecorator implements Appointment {
    protected Appointment appointment;

    public AppointmentDecorator(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost();
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
