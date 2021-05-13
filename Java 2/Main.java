import Banking.*;
import Customer.CustomerDatabase;
import Customer.CustomerSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static Connection getConnection() {
        try{
            String url = "jdbc:mysql://localhost:3836/proiectpao";
            String user = "root";
            String password = "rabJVOSDjsfrtKLp";

            return DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean end = false;
        var connection = Main.getConnection();

    var patientDatabase = new PatientDatabase(connection);
    var prognosticDatabase = new PrognosticDatabase(connection);
    var appointmentDatabase = new AppointmentDatabase(connection);
    var freeAppointmentDatabase = new FreeAppointmentDatabase(connection);
    
    
    MainService mainService = new MainService(patientDatabase, prognosticDatabase, appointmentDatabase, freeAppointmentDatabase);
    AuditService auditService = new AuditService();
    
    List<String> availableCommands = Arrays.asList("create_patient", "create_patient_doctor", "get_patient", "get_patient_price", "get_patient_appointments", "load_patient_appointment", "create_prognostic", "create_patient_appointment", "create_patient_free_appointment", "close_patient_appointment", "get_patinet_prognostics", "end");


    while (!end){
            System.out.println("Insert command: (help - see commands)");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try{
                switch (command) {
                    case "create_patient" -> mainService.createPatient(in);
                    case "create_patient_doctor" -> mainService.createPatientDoctor(in);
                    case "get_patient" -> mainService.getPatient(in);
                    case "get_patient_price" -> mainService.getPatientPrice(in);
                    case "get_patient_appointments" -> mainService.getPatientAppointments(in);
                    case "get_patient_appointment" -> mainService.getPatientAppointment(in);
                    case "load_patient_appointment" -> mainService.loadPatientAppointment(in);
                    case "create_prognostic" -> mainService.createPrognostic(in);
                    case "create_patient_appointment" -> mainService.createPatientAppointment(in);
                    case "create_patient_free_appointment" -> mainService.createPatientFreeAppointment(in);
                    case "close_patient_appointment" -> mainService.closeAppointment(in);
                    case "get_patient_prognostics" -> mainService.getPatientPrognostics(in);
                    case "help" -> System.out.println(availableCommands.toString());
                    case "end" -> end = true;
                }
                if(availableCommands.contains(command))
                    auditService.logAction(command);
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        
    try{
            assert connection != null;
            connection.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }
