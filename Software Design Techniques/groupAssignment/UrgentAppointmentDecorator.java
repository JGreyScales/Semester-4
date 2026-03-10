public class UrgentAppointmentDecorator implements Appointment {
    protected Appointment appointment;

    public  UrgentAppointmentDecorator(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost() + 50.00;
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
