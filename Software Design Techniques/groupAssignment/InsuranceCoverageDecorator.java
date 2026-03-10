public class InsuranceCoverageDecorator implements Appointment {
    protected Appointment appointment;

    public  InsuranceCoverageDecorator(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost() * (1 - 0.4);
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
