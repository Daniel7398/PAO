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

public class AppointmentRepository {

    public void addAppointment(Appointment appointment) {
        String sql = "insert into appointments values (null, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, appointment.getName());
            statement.setInt(2, appointment.getPatientId());
            statement.setInt(3, appointment.getUniqueId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeAppointment (Appointment appointment) {
        String name  =appointment.getName;
        int patientId = appointment.getPatientId;
        int uniqueId = appointment.getUniqueId();
        String sql = "delete from appointments where name = " + name + " && patientIdr = " + patientId + " && uniqueId = '" + uniqueId + "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAppointmentNr (Appointment appointment) {
        String name  =appointment.getName;
        int patientId = appointment.getPatientId;
        int uniqueId = appointment.getUniqueId();
        String sql = "select Nr from from appointments where name = " + name + " && patientIdr = " + patientId + " && uniqueId = '" + uniqueId + "'";
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

    public void updateAppointmentByNr(int Nr, String field, String value) {
        if (field.equals("uniqueId")) {
            String sql = "update appointments set uniqueId = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("patientId")) {
            String sql = "update appointments set patientId = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int numberOfAppointmentsPerPatient(int Nr) {
        String sql = "select count(*) from appointments where patientId = ? ";
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