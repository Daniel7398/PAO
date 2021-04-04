package Consultation;

public class AppointmentFactory {

  

    public Appointment createAppointment(String name, String NumbeR){
        return new Appointment(name, NumbeR);
    }
}
    