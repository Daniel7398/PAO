package Consultation;

public class FreeAppointmentFactory {

    public FreeAppointment createFreeAppointment(String name, String NumbeR){
        return new FreeAppointment(name, NumbeR);
    }
}