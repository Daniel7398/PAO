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


public class PrimaryDoctorRepository {

    public void addPrimaryDoctor(PrimaryDoctor primaryDoctor) {
        String sql = "insert into practitioners values (null, ?, ?, ?,?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, primaryDoctor.getDoctorId());
            statement.setString(2, primaryDoctor.getFirstName());
            statement.setString(3, primaryDoctor.getLastName);
            statement.setString(4, primaryDoctor.getCNP());
            statement.setString(5, primaryDoctor.getDoctorProfession());
            statement.setDate(6, primaryDoctor.getBirthDate());
            statement.setString(7, primaryDoctor.getEmail());
            statement.setString(8, primaryDoctor.getPhone());
            statement.setString(9, primaryDoctor.getNumbeR());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePrimaryDoctor(PrimaryDoctor primaryDoctor) {
        String sql = "delete from primaryDoctors where doctorID = '" + primaryDoctor.getDoctorID() + "' && firstName = '" + primaryDoctor.getFirstName() + "' && lastName = '" + primaryDoctor.getLastName() "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrimaryDoctorById(int Nr, String field, String value) {
        if (field.equals("doctorID")) {
            String sql = "update primaryDoctors set doctorID = ? where Nr= ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("firstName")) {
            String sql = "update primaryDoctors set firstName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("lastName")) {
            String sql = "update primaryDoctors set lastName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("CNP")) {
            String sql = "update primaryDoctors set CNP = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("doctorProfession")) {
            String sql = "update primaryDoctors set doctorProfession = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("birthDate")) {
            String sql = "update primaryDoctors set birthDate = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setDate(1, primaryDoctor.getBirthDate);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("email")) {
            String sql = "update primaryDoctors set email = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("phone")) {
            String sql = "update primaryDoctors set phone = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("NumbeR")) {
            String sql = "update primaryDoctors set NumbeR = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPrimaryDoctorNr (primaryDoctor primaryDoctor) {
        return getPrimaryDoctorNrByDoctorID(primaryDoctor.getDoctorID(), primaryDoctor.getFirstName());
    }

    public int getPrimaryDoctorNrByName (Int doctorID, String firstName) {
        String sql = "select Nr from primaryDoctorss where doctorID = ? && firstName = ?";
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