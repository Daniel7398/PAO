package Consultation;

import java.util.Calendar;
import java.util.Date;

public class FreeAppointment extends Appointment{
    private final Date appointmentDate;
    private final int priority;

    public SavingsAccount(String name, String NumbeR) {
        super(name, NumbeR);

        this.appointmentDate = new Date();
        this.priority = 5;
    
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public int getPriority() {
        return priority;
    }
}