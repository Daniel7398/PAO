package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class FreeAppointmentDatabase {
    Connection connection;

    public FreeAppointmentDatabase(Connection connection) {
        this.connection = connection;
    }
    
    public List<FreeAppointment> read(){
        List<FreeAppointment> freeAppointments = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM FreeAppointments");
            while(result.next()) {
                FreeAppointment current = new FreeAppointment(result);
                freeAppointments.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return freeAppointments;
    }
    
    public void update(FreeAppointment newFreeAppointment){
        try{
            String query = "UPDATE FreeAppointments SET price = ?, name = ?, patientId = ?, startDate = ?, endDate = ?, priority = ? WHERE NumbeR = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDouble(1, newFreeAppointment.getPrice());
            preparedStmt.setString(2, newFreeAppointment.getName());
            preparedStmt.setInt(3, newFreeAppointment.getPatientId());
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(newFreeAppointment.getStartDate()));
            preparedStmt.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(newFreeAppointmentt.getEndDate()));
            preparedStmt.setInt(6, newFreeAppointment.getPriority());
            preparedStmt.setString(7, newFreeAppointment.getNumbeR());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void create(FreeAppointment freeAppointment){
        try{
            String query = "INSERT INTO FreeAppointments (NumbeR, price, name, patientId, startDate, endDate, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, freeAppointment.getNumbeR());
            preparedStmt.setDouble(2, freeAppointment.getAppointment());
            preparedStmt.setString(3, freeAppointment.getName());
            preparedStmt.setInt(4, freeAppointment.getPatientId());
            preparedStmt.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(freeAppointment.getStartDate()));
            preparedStmt.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(freeAppointment.getEndDate()));
            preparedStmt.setInt(7, freeAppointment.getPriority());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void delete(FreeAppointment freeAppointment){
        try{
            String query = "DELETE FROM FreeAppointments WHERE NumbeR = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, freeAppointment.getNumbeR());
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}