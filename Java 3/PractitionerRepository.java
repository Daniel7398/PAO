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


public class PractitionerRepository {

    public void addPractitioner(Practitioner practitioner) {
        String sql = "insert into practitioners values (null, ?, ?, ?,?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, practitioner.getDoctorId());
            statement.setString(2, practitioner.getFirstName());
            statement.setString(3, practitioner.getLastName);
            statement.setString(4, practitioner.getCNP());
            statement.setString(5, practitioner.getDoctorProfession());
            statement.setDate(6, practitioner.getBirthDate());
            statement.setString(7, practitioner.getEmail());
            statement.setString(8, practitioner.getPhone());
            statement.setString(9, practitioner.getNumbeR());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePractitioner(Practitioner practitioner) {
        String sql = "delete from practitioners where doctorID = '" + practitioner.getDoctorID() + "' && firstName = '" + practitioner.getFirstName() + "' && lastName = '" + practitioner.getLastName() "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePractitionerById(int Nr, String field, String value) {
        if (field.equals("doctorID")) {
            String sql = "update practitioners set doctorID = ? where Nr= ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(value));
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("firstName")) {
            String sql = "update practitioners set firstName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("lastName")) {
            String sql = "update practitioners set lastName = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("CNP")) {
            String sql = "update practitioners set CNP = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("doctorProfession")) {
            String sql = "update practitioners set doctorProfession = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("birthDate")) {
            String sql = "update practitioners set birthDate = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setDate(1, practitioner.getBirthDate);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("email")) {
            String sql = "update practitioners set email = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("phone")) {
            String sql = "update practitioners set phone = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (field.equals("NumbeR")) {
            String sql = "update practitioners set NumbeR = ? where Nr = ?";
            try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
                statement.setString(1, value);
                statement.setInt(2, Nr);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getPractitionerNr (Practitioner practitioner) {
        return getPractitionerNrByDoctorID(practitioner.getDoctorID(), practitioner.getFirstName());
    }

    public int getPractitionerNrByName (Int doctorID, String firstName) {
        String sql = "select Nr from practitioners where doctorID = ? && firstName = ?";
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