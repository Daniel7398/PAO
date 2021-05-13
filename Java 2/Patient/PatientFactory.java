package Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class PatientFactory {
    private static int uniqueID = 0;

    public static void incrementUniqueId(int inc) {
        PatientFactory.uniqueId += inc;
    }
    
    public Patient createPatient(Scanner in) throws ParseException {
        return new Patient(uniqueId++, in);
    }
    
    public Patient createPatient(ResultSet in) throws SQLException {
        return new Patient(uniqueId++, in);
    }

}