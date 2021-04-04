package Patient;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class PatientFactory {
    private static int uniqueID = 0;

    public Patient CreatePatient(String FirstName, String LastName, String CNP, Date BirthDate, String Email, String Phone, Address Address){
        return new Patient(uniqueID++, FirstName, LastName, CNP, BirthDate, Email, Phone, Address);
    }

    public Patient CreatePatient(Scanner in) throws ParseException {
        return new Patient(uniqueID++, in);
    }
}