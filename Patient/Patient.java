package Patient;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Patient {
    private int userID;
    private String FirstName, LastName, CNP;
    private Date BirthDate;
    private String Email, Phone;
    private Address Address;

    private final List<Appointment> appointments = new ArrayList<>();
    private final Map<String, Appointment> appointmentsMap = new HashMap<>();
    private final List<FreeAppointment> freeAppointments = new ArrayList<>();

    private final AppointmentFactory appointmentFactory = new AppointmentFactory();
    private final FreeAppointmentFactory freeAppointmentFactory = new FreeAppointmentsFactory();
    

    public Patient(int userID, String FirstName, String LastName, String CNP, Date BirthDate, String Email, String Phone, Address Address) {
        this.userID = userID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.CNP = CNP;
        this.BirthDate = BirthDate;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
    }

    public Patient(int uniqueID, Scanner in) throws ParseException {
        this.userID = uniqueID;
        this.read(in);
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.FirstName = in.nextLine();
        System.out.println("Last name: ");
        this.LastName = in.nextLine();
        System.out.println("CNP: ");
        this.CNP = in.nextLine();
        System.out.println("Birth Date (yyyy-MM-dd): ");
        this.BirthDate = new SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine());
        System.out.println("Email: ");
        this.Email = in.nextLine();
        System.out.println("Phone: ");
        this.Phone = in.nextLine();
        System.out.println("Address: ");
        this.Address = new Address(in);
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(var appointment: appointments)
            totalPrice += appointment.getPrice();
        return totalPrice;
    }


    public void createAppointment(String name){
        Appointment newAppointment = this.appointmentFactory.createAppointment(name);
        this.appointments.add(newAppointment);
        this.appointmentsMap.put(newAppointment.getNumber(), newAppointment);
    }

    public void createFreeAppointment(String name){
        FreeAppointment newFreeAppointment = this.FreeAppointmentFactory.createFreeAppointment(name);
        this.freeAppointments.add(newFreeAppointment);
    }

    public void cancellationAppointment(String NumbeR) throws Exception {
        if(this.appointments.size()<=1)
            throw new Exception("There has to be at least one appointment associated with the user!");
        if(!this.appointmentsMap.containsKey(NumbeR))
            throw new Exception("Invalid appointment number!");
        Appointment appointmentToBeCanceled = this.appointmentsMap.get(NumbeR);
        if(appointmentToBeCanceled.getPrice()!=0)
            throw new Exception(" ");
        appointments.remove(appointmentToBeCanceled);
        appointmentsMap.remove( NumbeR);
    }
    
    
    
    @Override
    public String toString() {
        return "{" +
                "userID=" + userID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", BirthDate=" + BirthDate +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address=" + Address.toString() +
                '}';
    }

    public List<Prognostics> getPrognosticsHistory(){
        List<Prognostics> prognostics = new ArrayList<>();
        for(var appointment: this.appointments)
            prognostics.addAll(appointment.getPrognosticsHistory());
        return prognostics;
    }

    public List<Prognostics> getPrognosticsHistory(int year){
        List<Prognostics> prognostics = new ArrayList<>();
        for(var appointment: this.appointments)
            prognostics.addAll(appointment.getPrognosticsHistory(year));
        return prognostics;
    }

    public Map<String, Appointment> getAppointmentsMap() {
        return appointmentsMap;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<FreeAppointment> getFreeAppointments() {
        return freeAppointments;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }
}