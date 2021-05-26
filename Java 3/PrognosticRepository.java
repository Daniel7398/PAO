package repository;

import config.*;
import Consultation.*;
import Doctor.*
import Patient.*

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class PrognosticRepository {

    public void addPrognostic(Prognostic prognostic) {
        String sql = "insert into prognostics values (null, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, prognostic.getINumber());
            statement.setDouble(2, prognostic.getPrice());
            statement.setString(3, prognostic.getDescription());
            statement.setDate(4, prognostic.getCreationDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePrognostic(Prognostic prognostic) {
        String sql = "delete from prognostics where iNumber= '" + prognostic.getINumber() + "' && price = '" + prognostic.getPrice() + "' && description= '" + prognostic.getDescription() + "' && creationDate = '" + prognostic.getCreationDate() "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrognosticByNr(int Nr, String field, String value) {
        if (field.equals("iNumber")) {
            String sql = "update prognostics set iNumber = ? where Nr= ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("price")) {
            String sql = "update prognostics set price = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setDouble(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("description")) {
            String sql = "update prognostics set description = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("creationDate")) {
            String sql = "update prognostics set creationDate = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setDate(1, prognostic.getDate());
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
        }
    }

    public int getPrognosticNr (Prognostic prognostic) {
        return getPrognosticNrByINumber(prognsotic.getINumber());
    }

    public int getPrognosticIdByINumber (Int iNumber) {
        String sql = "select Nr from prognostics where iNumber= ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, iNumber);
            statement.setString(2, firstName);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}