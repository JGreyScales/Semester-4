public class AfterHoursDecorator implements Appointment {
    protected Appointment appointment;

    public  AfterHoursDecorator(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost() + 30.00;
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
