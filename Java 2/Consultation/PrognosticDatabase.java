package Banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PrognosticDatabase {
    Connection connection;

    public PrognosticDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<Prognostic> read(){
        List<Prognostic> prognostics = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Prognostics");
            while(result.next()) {
                Prognostic current = new Prognostic(result);
                prognostics.add(current);
            }
            statement.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return prognostics;
    }
    
    public void update(Prognostic newPrognostic){
        try{
            String query = "UPDATE Prognostics SET description = ? WHERE iNumbeR = ? AND creationDate = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newPrognostic.getDescription());
            preparedStmt.setString(2, newPrognostic.getINumbeR());
            preparedStmt.setString(3, (new SimpleDateFormat("yyyy-MM-dd h:m:i")).format(newPrognostic.getCreationDate()));
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
     public void create(Prognostic prognostic){
        try{
            String query = "INSERT INTO Prognostics (iNumbeR, price, description, creationDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, prognostic.getINumbeR());
            preparedStmt.setDouble(2, prognostic.getPrice());
            preparedStmt.setString(3, prognostic.getDescription());
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd h:m:i")).format(prognostic.getCreationDate()));
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void delete(Prognostic prognostic){
        try{
            String query = "DELETE FROM Prognostics WHERE iNumbeR = ?, creationDate = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, prognostic.getINumbeR());
            preparedStmt.setString(2, (new SimpleDateFormat("yyyy-MM-dd h:m:i")).format(prognostic.getCreationDate()));
            preparedStmt.execute();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}

