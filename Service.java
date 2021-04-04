import Consultation.Appointment;
import Patient.Patient;
import Patient.PatientFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private final List<Patient> patients = new ArrayList<>();
    private final PatientFactory patientFactory = new PatientFactory();

    public List<Patient> getPatients() {
        return patients;
    }

    private Patient getPatient(Scanner in) throws Exception{
        if(this.patients.size()==0)
            throw new Exception("No patients added!");
        if(this.patients.size()==1)
            return patients.get(0);
        System.out.println("Patient id [0-"+(this.patients.size()-1)+"]: ");
        int patientId = Integer.parseInt(in.nextLine());
        return patients.get(patientId);
    }

    private Appointment getAppointment(Scanner in, Patient patient) throws Exception{
        System.out.println("Patient appointments: " + patient.getAppointments().toString());
        System.out.println("Choose NumbeR: ");
        var NumbeR = in.nextLine();
        return patient.getAppointmentsMap().get(NumbeR);
    }

    public void createPatient(Scanner in) throws ParseException {
        this.patients.add(patientFactory.createPatient(in));
        System.out.println("Patient created");
    }

    
    public void showPatient(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        System.out.println(patient.toString());
    }

    public void showPatientPayment(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        System.out.println(patient.getFirstName() + " " + patient.getLastName() + " has a total payment of: " + patient.getTotalPrice() + " lei.");
    }

    public void showPatientAppointments(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        System.out.println(patient.getPatients().toString());
    }

    public void createPatientAppointment(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        System.out.println("Appointment name: ");
        String name = in.nextLine();
        patient.createAppointment(name);
        System.out.println("Appointment created");
    }

    public void createPatientFreeAppointment(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        System.out.println("Free Appointment name: ");
        String name = in.nextLine();
        patient.createFreeAppointment(name);
        System.out.println("Free Appointment created");
    }
    
    
    public void createPatientDoctor(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        var appointment = this.getAppointment(in, patient);
        System.out.println("Patient's doctor name: ");
        var name = in.nextLine();
        appointment.createDoctor(name);
    }


    public void createPrognostic(Scanner in) throws Exception {
        System.out.println("Appointment: ");
        var NumbeR = in.nextLine();
        System.out.println("Price:")
        int price = Integer.parseInt(in.nextLine());
        System.out.println("Description: ");
        String description = in.nextLine();
        Appointment appointmenT = null;
        for(var patient: patients)
            if(patient.getAppointmentsMap().containsKey(NumbeR))
                appointmenT = customer.getAccountsMap().get(NumbeR);
        if(appointmenT==null)
            throw new Exception("Cannot find appointment!");
        appointmenT.createPrognostic(appointmenT, description);
        System.out.println("Prognostic created");
    }
    

    public void canceledAppointment(Scanner in) throws Exception {
        var patient = this.getPatient(in);
        var appointment = this.getAppointment(in, customer);
        patient.canceledAppointment(appointment.getNumbeR());
        System.out.println("Appointment canceled!");
    }


    public void showPatientAppointment(Scanner in) throws Exception{
        var patient = this.getPatient(in);
        var appointment = this.getAppointment(in, patient);
        System.out.println(appointment.toString());
    }

    public void showPatientPrognostics(Scanner in) throws Exception{
        var patient = this.getPatient(in);
        System.out.println("Show all prognostics? (y/n)");
        boolean showAll = in.nextBoolean();
        if(showAll)
            System.out.println(patient.getPrognosticHistory());
        else{
            System.out.println("Select year: ");
            var year = in.nextInt();
            System.out.println(patient.getPrognosticHistory(year));
        }
        System.out.println();
    }

}