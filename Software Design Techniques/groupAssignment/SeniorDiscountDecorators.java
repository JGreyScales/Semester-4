public class SeniorDiscountDecorators {
    protected Appointment appointment;

    public  SeniorDiscountDecorators(Appointment appointment){
        this.appointment = appointment;
    }

    public double getCost() {
        return this.appointment.getCost() * (1 - 0.15);
    }

    public String getDescription() {
        return this.appointment.getDescription();
    }
}
