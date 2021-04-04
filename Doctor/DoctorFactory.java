package Doctor;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class DoctorFactory {
    private static int uniqueId = 0;

    public Doctor createDoctor(String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone){
        return new Doctor(uniqueId++, firstName, lastName, CNP,doctorProfession, birthDate, email, phone);
    }

    public Doctor createDoctor(Scanner in) throws ParseException {
        return new Doctor(uniqueId++, in);
    }
}