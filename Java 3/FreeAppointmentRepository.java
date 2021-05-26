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

public class FreeAppointmentRepository {

    public void addFreeAppointment(FreeAppointment freeappointment) {
        String sql = "insert into freeappointments values (null, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, freeappointment.getName());
            statement.setInt(2, freeappointment.getPatientId());
            statement.setInt(3, freeappointment.getUniqueId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeFreeAppointment (FreeAppointment freeappointment) {
        String name  = freeappointment.getName;
        int patientId = freeappointment.getPatientId;
        int uniqueId = freeappointment.getUniqueId();
        String sql = "delete from freeappointments where name = " + name + " && patientIdr = " + patientId + " && uniqueId = '" + uniqueId + "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public int getFreeAppointmentNr (FreeAppointment freeappointment) {
        String name  = freeappointment.getName;
        int patientId = freeappointment.getPatientId;
        int uniqueId = freeappointment.getUniqueId();
        String sql = "select Nr from from freeappointments where name = " + name + " && patientIdr = " + patientId + " && uniqueId = '" + uniqueId + "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updateFreeAppointmentByNr(int Nr, String field, String value) {
        if (field.equals("uniqueId")) {
            String sql = "update freeappointments set uniqueId = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("patientId")) {
            String sql = "update freeappointments set patientId = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int numberOfFreeAppointmentsPerPatient(int Nr) {
        String sql = "select count(*) from freeappointments where patientId = ? ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, Nr);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}