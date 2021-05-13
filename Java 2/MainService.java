import Banking.*;
import Customer.Customer;
import Customer.CustomerFactory;
import Customer.CustomerDatabase;

import java.text.ParseException;
import java.util.*;


public class MainService {

    /// Storage
    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<FreeAppointment> freeAppointments = new ArrayList<>();
    private List<Prognostic> prognostics = new ArrayList<>();

    private final Map<String, Appointmentt> appointmentsMap = new HashMap<>();
    private final PatientFactory patientFactory = new PatientFactory();
    private final AppointmentFactory appointmentFactory = new AppointmentFactory();

    private final PatientDatabase patientDatabase;
    private final PrognosticDatabase prognosticDatabase;
    private final AppointmentDatabase appointmentDatabase;
    private final FreeAppointmentDatabase freeAppointmentDatabase;
    
    /// Getters
    public List<Patient> getPatients() {
        return patients;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public List<FreeAppointment> getFreeAppointments() {
        return freeAppointments;
    }
    public List<Prognostic> getPrognostics() {
        return prognostics;
    }

    /// Setters
    public void setPatients(List<Patient> patients){
        this.patients = patients;
    }
    public void setppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    public void setFreeAppointments(List<FreeAppointment> freeAppointments) {
        this.freeAppointments = freeAppointments;
    }
    public void setPrognostics(List<Prognostic> prognostics) {
        this.prognostics = prognostics;
    }
    
    public MainService(PatientDatabase patientDatabase, PrognosticDatabase prognosticDatabase, AppointmenttDatabase appointmentDatabase, FreeAppointmentDatabase freeAppointmenttDatabase) {
        this.patientDatabase = patientDatabase;
        this.prognosticDatabase = prognosticDatabase;
        this.appointmentDatabase = appointmentDatabase;
        this.freeAppointmentDatabase = freeAppointmentDatabase;

        this.patients = patientDatabase.read();
        this.prognostics = prognosticnDatabase.read();
        this.appointments = appointmentDatabase.read();
        this.freeAppointments = freeAppointmentDatabase.read();

        this.linkAppointments();
    }
    
     /// Utils
    private Patient getPatientFromInput(Scanner in) throws Exception{
        if(this.patients.size()==0)
            throw new Exception("No patients added!");
        if(this.patients.size()==1)
            return patients.get(0);
        System.out.println("Patient id [0-"+(this.patients.size()-1)+"]: ");
        int patientId = Integer.parseInt(in.nextLine());
        return patients.get(patientId);
    }
    
    public void linkAppointments(){
        for(var appointment: this.appointments)
            this.appointmentsMap.put(appointmentt.getNumbeR(), appointment);
    }
    
    /// Actions
    public void createPatiet(Scanner in) throws ParseException {
        Patient newPatient = patientFactory.createPatient(in);
        this.patients.add(newPatient);
        this.appointments.add(appointmentFactory.createppointment(newPatient.getFirstName() + " " + newPatient.getLastName(), newPatient.getPatientId()));
        this.patientDatabase.create(newPatient);
        System.out.println("Patient created");
    }
    
    
    public void getPatient(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        System.out.println(patient.toString());
    }
    
    private Appointment getppointmenttFromInput(Scanner in, Patient patient) throws Exception {
        List<Appointment> patientsAppointments = patient.filterAppointments(this.appointments);
        System.out.println("Patient appointmens: " + patientsAppointments);
        System.out.println("Choose NumbeR: ");
        var NumbeR = in.nextLine();
        if(!this.appointmentsMap.containsKey(NumbeR))
            throw new Exception("Invalid NumbeR!");
        var appointment = appointmentsMap.get(NumbeR);;
        if(appointment.getPatientId() != patient.getPatientId())
            throw new Exception("The given NumbeR is not associated with the selected patient");
        return appointment;
    }
    
    public void getPatientPrice(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        var patientAppointments = patient.filterAppointments(this.appointments);
        double totalPrice = 0;
        for(var appointment: patientAppointments)
            totalPrice += appointment.getPrice();
        System.out.println(patient.getFirstName() + " " + patient.getLastName() + " has a total price of: " + totalPrice + " lei.");
    }
    
    public void getPatientAppointments(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        List<Appointment> patientsAppointments = patient.filterAppointments(this.appointments);
        System.out.println(patientsAppointments.toString());
    }
    
    public void createPatientAppointment(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        System.out.println("Appointment name: ");
        String name = in.nextLine();
        Appointment newAppointment = this.appointmentFactory.createAppointment(name, patient.getPatientId());
        appointments.add(newAppointment);
        appointemntsMap.put(newAppointment.getNumbeR(), newAppointment);
        this.appointmentDatabase.create(newAppointment);
        System.out.println("Appointment created");
    }
    
    public void createPatientFreeAppointment(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        System.out.println("Free Appointment name: ");
        String name = in.nextLine();
        FreeAppointment newFreeAppointment = this.appointmentFactory.createFreeAppointment(name, patient.getPatientId());
        this.freeAppointments.add(newFreeAppointment);
        this.freeAppointmentDatabase.create(newFreeAppointment);
        System.out.println("Free Appointment created");
    }
    
    public void createPatientDoctor(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        var appointment = this.getAppointmentFromInput(in, patient);
        System.out.println("Patient's doctor name: ");
        var name = in.nextLine();
        appointment.addDoctor(name);
    }
    
    public void loadPatientAppointment(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        System.out.println("How much the appointment costs?: ");
        int appointment = Integer.parseInt(in.nextLine());
        var patientAppointments = patient.filterAppointments(this.appointments);
        patientAppointments.get(0).setPrice(price);
        System.out.println("The cost has been modified!");
    }
    
    public void createPrognostic(Scanner in) throws Exception {
        System.out.println("NumbeR: ");
        var IBAN1 = in.nextLine();
        System.out.println("Price: ");
        int amount = in.nextInt();
        System.out.println("Description: ");
        String description = in.nextLine();

        Appointment appointment = null;

        if(appointmentsMap.containsKey(NumbeR))
            appointment = appointmentsMap.get(NumbeR);



        var newPrognostic = new Prognostic(NumbeR, amount, description);
        this.prognostics.add(newPrognostic);
        this.prognosticDatabase.create(newPrognostic);
        System.out.println("Prognostic finished");
    }

    public void closeAppointment(Scanner in) throws Exception {
        var patient = this.getPatientFromInput(in);
        var appointment = this.getAppointmenttFromInput(in, patient);

        if(patient.filterAppointments(this.appointments).size()<=1)
            throw new Exception("There has to be at least one appointment associated with the patient!");
        this.appointmensMap.remove(appointment.getNumbeR());
        this.appointments.remove(appointment);
        this.appointmenttDatabase.delete(appointment);
        System.out.println("Appointment closed!");
    }

    public void getPatientAppointment(Scanner in) throws Exception{
        var patient = this.getPatientFromInput(in);
        var appointment = this.getAppointmentFromInput(in, patient);
        System.out.println(appointment.toString());
    }
    
    public void getPatientPrognostics(Scanner in) throws Exception{
        var patient = this.getPatientFromInput(in);
        System.out.println("Show all prognostics? (y/n)");
        String showAll = in.nextLine();
        if(showAll.equals("y")) {
            System.out.println(patient.filterPrognostics(appointments, prognostics));
        }
        else{
            System.out.println("Select year: ");
            var year = in.nextInt();
            System.out.println(patient.filterPrognostics(appointments, prognostics, year));
        }
        System.out.println();
    }

}