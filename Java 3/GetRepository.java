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

public class GetRepository {
     public Optiona<Address> getAddressByNr(int Nr) {
        String sql = "select * from address where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String Street = result.getString(2);
                String City = result.getString(3);
                String County = result.getString(3);
                Integer PostalCode = result.getInt(4);
                return Optional.of(new Supplier(Street, City, County, PostalCode));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Doctor> getDoctorByNr(int Nr) {
        String sql = "select * from doctors where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer doctorID = result.getInt(2);
                String firstName = result.getString(3);
                String lastName = result.getString(4);
                String CNP = result.getString(5);
                String doctorProfession = result.getString(6);
                Date birthDate = result.getDate(7);
                String email = result.getString(8);
                String phone = results.getString(9);
                String NumbeR = results.getString(10);
                return Optional.of(new Doctor( doctorID, firstName, lastName, CNP, doctorProfession, birthDate, email, phone, NumbeR));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Patient> getPatientByNr(int Nr) {
        String sql = "select * from patients where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer patientID = result.getInt(2);
                String  FirstName = result.getString(3);
                String  LastName = result.getString(3);
                String CNP = result.getString(5);
                Date BirthDate = result.getDate(6);
                String Email = result.getString(7);
                String Phone = results.getString(8);
                Optional<Address> address = getAddressByNr(NrAddress);
                if (supplier.isPresent()) {
                    return Optional.of(new Patient(patientID, FirstName, LastName, CNP, BirthDate, Email, Phone, Address.get() );
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    

    public Optional<Appointment> getAppointmentByNr(int Nr {
        String sql = "select * from appointments where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String name = result.getString(2);
                int patientId = result.getInt(3);
                int uniqueId = result.getInt(4);
                return Optional.of(new Appointment( name, patientId, uniqueId));
    
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public Optional<FreeAppointment> getFreeAppointmentByNr(int Nr {
        String sql = "select * from freeappointments where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String name = result.getString(2);
                int patientId = result.getInt(3);
                int uniqueId = result.getInt(4);
                return Optional.of(new FreeAppointment( name, patientId, uniqueId));
    
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public Optional<Prognostic> getPrognosticByNr(int Nr {
        String sql = "select * from freeprognostics where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String iNumber = result.getString(2);
                Double price = result.getDouble(3);
                String description = result.getInt(4);
                Date creationDate = result.getDate(5);
                return Optional.of(new FreeAppointment( iNumbeR, price, description, creationDate));
    
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public Optional<Practitioner> getPractitionerByNr(int Nr) {
        String sql = "select * from practitioners where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer doctorID = result.getInt(2);
                String firstName = result.getString(3);
                String lastName = result.getString(4);
                String CNP = result.getString(5);
                String doctorProfession = result.getString(6);
                Date birthDate = result.getDate(7);
                String email = result.getString(8);
                String phone = results.getString(9);
                String NumbeR = results.getString(10);
                return Optional.of(new Doctor( doctorID, firstName, lastName, CNP, doctorProfession, birthDate, email, phone, NumbeR));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
    public Optional<PrimaryDoctor> getPrimaryDoctorByNr(int Nr) {
        String sql = "select * from primarydoctors where Nr = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setLong(1, Nr);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer doctorID = result.getInt(2);
                String firstName = result.getString(3);
                String lastName = result.getString(4);
                String CNP = result.getString(5);
                String doctorProfession = result.getString(6);
                Date birthDate = result.getDate(7);
                String email = result.getString(8);
                String phone = results.getString(9);
                String NumbeR = results.getString(10);
                return Optional.of(new Doctor( doctorID, firstName, lastName, CNP, doctorProfession, birthDate, email, phone, NumbeR));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private int isDoctor (int doctorID, String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone, String NumbeR) {
        String sql = "select Nr from doctors where doctorID = '" + doctorID + "' && firstName= '" + firstName + "' && lastName = " + lastName + " && CNP = '" + CNP + "' && doctorProfession= '" + doctorProfession + "' && birthDate = '" + birthDate " && email = '" + email + "' && phone = '" + "' && NumbeR = '" + NumbeR + "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                return Nr;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int isPatient (int doctorID, String firstName, String lastName, String CNP, String doctorProfession, Date birthDate, String email, String phone, String NumbeR) {
        String sql = "select Nr from doctors where doctorID = '" + doctorID + "' && firstName= '" + firstName + "' && lastName = " + lastName + " && CNP = '" + CNP + "' && doctorProfession= '" + doctorProfession + "' && birthDate = '" + birthDate " && email = '" + email + "' && phone = '" + "' && NumbeR = '" + NumbeR + "'";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                return Nr;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public Set<Doctor> getAllDoctors () {
        String sql = "select Nr from doctors";
        Set<Doctor> docs = new TreeSet<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                Optional<Doctor> doc = getDoctorByNr(Nr);
                if (doc.isPresent()) {
                    docs.add(doc.get());
                }
            }
            return docs;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Patient> getAllPatients () {
        String sql = "select Nr from patients";
        Set<Patient> patients = new TreeSet<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                Optional<Patient> pat = getPatientByNr(Nr);
                if (pat.isPresent()) {
                    patients.add(pat.get());
                }
            }
            return patients;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Appointment> getAllAppointments () {
        String sql = "select * from appointments";
        List<Appointment> appointments = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                Optional<Appointment> app = getAppointmentByNr(Nr);
                if (app.isPresent()) {
                    appointments.add(app.get());
                }
            }
            return appointments;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Prognostic> getAllPrognostics () {
        String sql = "select * from prognostics";
        List<Prognostic> prognostics = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                Optional<Prognostic> prog = getPrognosticById(id);
                if (prog.isPresent()) {
                    prognostics.add(prog.get());
                }
            }
            return prognostics;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<FreeAppointment> getAllFreeAppointments () {
        String sql = "select * from freeappointments";
        List<FreeAppointment> freeappointments = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int Nr = result.getInt(1);
                Optional<FreeAppointment> freeapp = getFreeAppointmentByNr(Nr);
                if (freeapp.isPresent()) {
                    freeappointments.add(freeapp.get());
                }
            }
            return appointments;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    

}