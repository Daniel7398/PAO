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


public class DoctorRepository {

    public void addDoctor(Doctor doctor) {
        String sql = "insert into doctors values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, doctor.getDoctorId());
            statement.setString(2, doctor.getFirstName());
            statement.setString(3, doctor.getLastName);
            statement.setString(4, doctor.getCNP());
            statement.setString(5, doctor.getDoctorProfession());
            statement.setDate(6, doctor.getBirthDate());
            statement.setString(7, doctor.getEmail());
            statement.setString(8, doctor.getPhone());
            statement.setString(9, doctor.getNumbeR());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeDoctor(Doctor doctor) {
        String sql = "delete from doctors where doctorID = '" + doctor.getDoctorID() + "' && firstName = '" + doctor.getFirstName() + "' && lastName = '" + doctor.getLastName() "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDoctorByNr(int Nr, String field, String value) {
        if (field.equals("doctorID")) {
            String sql = "update doctors set doctorID = ? where Nr= ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("firstName")) {
            String sql = "update doctors set firstName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("lastName")) {
            String sql = "update doctors set lastName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("CNP")) {
            String sql = "update doctors set CNP = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("doctorProfession")) {
            String sql = "update doctors set doctorProfession = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("birthDate")) {
            String sql = "update doctors set birthDate = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setDate(1, doctor.getBirthDate);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("email")) {
            String sql = "update doctors set email = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("phone")) {
            String sql = "update doctors set phone = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("NumbeR")) {
            String sql = "update doctors set NumbeR = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDoctorNr (Doctor doctor) {
        return getDoctorNrByDoctorID(doctor.getDoctorID(), doctor.getFirstName());
    }

    public int getDoctorNrByName (Int doctorID, String firstName) {
        String sql = "select Nr from doctors where doctorID = ? && firstName = ?";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, doctorID);
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