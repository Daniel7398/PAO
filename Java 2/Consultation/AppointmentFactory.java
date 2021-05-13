package Consultation;

public class AppointmentFactory {

    private static int uniqueId = 0;

    public static void incrementUniqueId(int inc) {
        AppointmentFactory.uniqueId += inc;
    }
    
    public Appointment createAppointment(String name, String patientId){
        return new Appointment(name, patientId, uniqueId++);
    }
    
    public FreeAppointment createFreeAppointment(String name, int patientId){
        return new FreeAppointment(name, patientId, uniqueId++);
    }
}