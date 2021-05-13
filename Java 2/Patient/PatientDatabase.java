package Patient;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PatientDatabase{
    Connection connection;

    PatientFactory patientFactory = new PatientFactory();

    public PatientDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<Patient> read(){
        List<Patient> patients = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Patients");
            while(result.next()) {
                Patient current = patientFactory.createPatient(result);
                patients.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return patients;
    }


    public void update(Patient newPatient){
        try{
            String query = "UPDATE Patients SET FirstName = ?, LastName = ?, CNP = ?, BirthDate = ?, Email = ?, Phone = ?, Street = ?, City = ?, County = ?, PostalCode = ? WHERE patientId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newPatient.getFirstName());
            preparedStmt.setString(2, newPatient.getLastName());
            preparedStmt.setString(3, newPatient.getCNP());
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(newPatient.getBirthDate()));
            preparedStmt.setString(5, newPatient.getEmail());
            preparedStmt.setString(6, newPatient.getPhone());
            preparedStmt.setString(7, newPatient.getAddress().getStreet());
            preparedStmt.setString(8, newPatient.getAddress().getCity());
            preparedStmt.setString(9, newPatient.getAddress().getCounty());
            preparedStmt.setInt(10, newPatient.getAddress().getPostalCode());
            preparedStmt.setInt(11, newPatient.getCustomerId());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void create(Patient patient){
        try{
            String query = "INSERT INTO Patients (patientId, FirstName, LastName, CNP, BirthDate, Email, Phone, Street, City, County, PostalCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, patient.getCustomerId());
            preparedStmt.setString(2, patient.getFirstName());
            preparedStmt.setString(3, patient.getLastName());
            preparedStmt.setString(4, patient.getCNP());
            preparedStmt.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(patient.getBirthDate()));
            preparedStmt.setString(6, patient.getEmail());
            preparedStmt.setString(7, patient.getPhone());
            preparedStmt.setString(8, patient.getAddress().getStreet());
            preparedStmt.setString(9, patient.getAddress().getCity());
            preparedStmt.setString(10, patient.getAddress().getCounty());
            preparedStmt.setInt(11, patient.getAddress().getPostalCode());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
     public void delete(Patient patient){
        try{
            String query = "DELETE FROM Patients WHERE patientId = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, patient.getPatientId());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
