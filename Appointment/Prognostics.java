package Consultation;

import java.util.Date;
import java.util.Scanner;

public class Prognostics {
    final private Appointment appointment;
    final private String description;
    final private Date creationDate;

    public Prognostics(Appointment appointment, String description) throws Exception {

        this.appointment = appointment;
        this.description = description;
        this.creationDate = new Date();
    }

    public Appointment getAppointment() {
        return appointment;
    }

   
    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}