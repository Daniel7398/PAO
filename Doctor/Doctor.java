package Doctor;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor {
    private int doctorID;
    private String firstName, lastName, CNP, doctorProfession;
    private Date birthDate;
    private String email, phone;


    public Doctor(int doctorID, String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone) {
        this.doctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.doctorProfession = doctorProfession;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public Doctor(int uniqueId, Scanner in) throws ParseException {
        this.doctorID = uniqueId;
        this.read(in);    }

    public void read(Scanner in) throws ParseException {
        System.out.println("First name: ");
        this.firstName = in.nextLine();
        System.out.println("Last name: ");
        this.lastName = in.nextLine();
        System.out.println("CNP: ");
        this.CNP = in.nextLine();
        System.out.println("Doctor Profession: ");
        this.doctorProfession = in.nextLine();
        System.out.println("Birth Date (yyyy-MM-dd): ");
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine());
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("Phone: ");
        this.phone = in.nextLine();
    }

    
    
    


    @Override
    public String toString() {
        return "{" +
                "doctorID=" + doctorID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", Doctor Profession='" + doctorProfession + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    

    

    
    
    public int getDoctorID() {
        return doctorID;
    }

    public void setdoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    
    public String getDoctorProfession() {
        return doctorProfession;
    }

    public void setDoctorProfession(String doctorProfession) {
        this.doctorProfession = doctorProfession;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}