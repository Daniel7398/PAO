package Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Patient {
    private final int patientID;
    private String FirstName, LastName, CNP;
    private Date BirthDate;
    private String Email, Phone;
    private Address Address;

    

    public Patient(int patientID, String FirstName, String LastName, String CNP, Date BirthDate, String Email, String Phone, Address Address) {
        this.patientID = patientID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.CNP = CNP;
        this.BirthDate = BirthDate;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
    }

    public Patient(int patientID, Scanner in) throws ParseException {
        this.patientID = patientID;
        this.read(in);
    }
    
    public Patient(int patientId, ResultSet in) throws SQLException {
        this.patientId = patientId;
        this.read(in);
    }
    
    public void read(ResultSet in) throws SQLException {
        this.FirstName = in.getString("firstName");
        this.LastName = in.getString("lastName");
        this.CNP = in.getString("CNP");
        this.BirthDate = in.getDate("birthDate");
        this.Email = in.getString("email");
        this.Phone = in.getString("phone");
        this.Address = new Address(in);
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
    
    
    public List<Appointment> filterAppointments(List<Appointment> allAppointments){
        var appointments = new ArrayList<Appointment>();
        for(var appointment: allAppointments)
            if(appointment.getPatientId() == this.getPatientId())
                appointments.add(appointmentt);
        return appointments;
    }

    public List<Prognostic> filterPrognostics(List<Appointment> allAppointments, List<Prognostic> allPrognostics){
        var prognostics = new ArrayList<Prognostic>();
        var appointments = this.filterAppointments(allAppointments);
        for(var appointment: appointments)
            prognostics.addAll(appointment.filterAppointments(allPrognostics));
        return prognostics;
    }
    
    public List<Prognostic> filterPrognostics(List<Appointment> allAppointments, List<Prognostic> allPrognostics, int year){
        var prognostics = new ArrayList<Prognostic>();
        var appointments = this.filterAppointments(allAppointments);
        for(var appointment: appointments)
            prognostics.addAll(appointment.filterPrognostics(allPrognostics, year));
        return prognostics;
    }
    
    
    
    @Override
    public String toString() {
        return "{" +
                "patientID=" + patientID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", BirthDate=" + BirthDate +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address=" + Address.toString() +
                '}';
    }
    
    public String toCSV(){
        return patientId +
                "," + FirstName +
                "," + LastName +
                "," + CNP +
                "," + (new SimpleDateFormat("yyyy-MM-dd")).format(BirthDate) +
                "," + Email +
                "," + Phone +
                "," + Address.toCSV();
    }

    public int getPatientID() {
        return patientID;
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