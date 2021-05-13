package Doctor;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class DoctorFactory {
    private static int uniqueId = 0;

    public Doctor addDoctor(String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone, String NumbeR){
        return new Doctor(uniqueId++, firstName, lastName, CNP,doctorProfession, birthDate, email, phone, NumbeR);
    }
    
    public Practitioner createPractitioner(String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone, String NumbeR){
        return new Practitoner(uniqueId++, firstName, lastName, CNP, doctorProfession, birthDate, email, phone, NumbeR);
    }
    
    public PrimaryDoctor createPrimaryDoctor(String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone, String NumbeR){
        return new PrimaryDoctor(uniqueId++, firstName, lastName, CNP, doctorProfession, birthDate, email, phone, NumbeR);
    }
}