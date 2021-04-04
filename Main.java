import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean command = true;
        Service service = new Service();

        while (!end){
            System.out.println("Insert command: ");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (command) {
                    case "create_patient" -> service.createPatient(in);
                    case "get_patient" -> service.showPatient(in);
                    case "get_patient_payment" -> service.showPatientPayment(in);
                    case "get_patient_appointments" -> service.showPatientAppointments(in);
                    case "get_patient_account" -> service.showPatientAppointment(in);
                    case "create_prognostic" -> service.createPrognostic(in);
                    case "create_patient_appointment" -> service.createPatientAppointment(in);
                    case "create_patient_free_appointment" -> service.createPatientFreeAppointment(in);
                    case "cancel_patient_appointment" -> service.canceledAppointment(in);
                    case "get_patient_prognostics" -> service.showPatientPrognostics(in);
                    case "end" -> command = false;
                }
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}