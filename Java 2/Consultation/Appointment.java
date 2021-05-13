package Consultation;

import Doctor.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Appointment implements Comparator<Prognostics> {
    protected String NumbeR;
    protected double price;
    protected String name;
    protected int patientId;
    

    protected List<Doctor> doctors = new ArrayList<>();

    private final DoctorFactory doctorFactory = new DoctorFactory();

    public Appointment(String name, String NumbeR) {
        this.name = name;
        this.NumbeR = NumbeR;
        this.price = 0;
    }
    
    public Account(String name, int patientId, int uniqueId) {
        this.NumbeR = this.generateNumbeR(uniqueId);
        this.price = 0;
        this.name = name;
        this.patientId = patientId;
    }
    
    public Appointment(ResultSet in) throws SQLException {
        this.NumbeR = in.getString("NumbeR");
        this.price = in.getDouble("price");
        this.name = in.getString("name");
        this.patientId = in.getInt("patientId");
    }
    
    public List<Prognostic> filterPrognostics(List<Prognostic> allPrognostics){
        List<Prognostic> prognostics = new ArrayList<>();
        for(var prognostic: allPrognostics)
            if(prognostic.getINumbeR().equals(this.NumbeR))
                prognostics.add(prognostic);
        return prognostics;
    }
    
    public List<Prognostic> filterPrognostics(List<Prognostic> allPrognostics, int year){
        List<Progsnotic> prognostics = new ArrayList<>();
        for(var prognostic: allPrognsotics)
            if(prognostic.getINumbeR().equals(this.NumbeR) && prognostic.getCreationDate().getYear()==year)
                prognostics.add(prognostic);
        return prognostics;
    }
    
    
    public void addDoctor(String name){
        Doctor newDoctor = doctorFactory.addDoctor(this.NumbeR, name);
        doctors.add(newDoctor);
    }


    public int compare(Prognostic prognostic1, Prognostic prognostic2){
        return prognostic1.getCreationDate().compareTo(prognostic2.getCreationDate());
    }
    
    

    public void setPrice(double price) {
        this.price = price;
    }

    
    public double getPrice() {
        return price;
    }
    
    public int getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }


    public String getNumbeR() {
        return NumbeR;
    }
    
    public double getPrice() {
        return price;
    }
    
    public List<Doctor> getDoctors() {
        return doctors;
    }



    @Override
    public String toString() {
        return "{" +
                "NumbeR='" + NumbeR + '\'' +
                ", Name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    
    public String toCSV() {
        return NumbeR +
                "," + price +
                "," + name +
                "," + patientId;
    }
    
    private String generateNumbeR(int uniqueId){
        String nmbr = "Nr";

        return nmbr + ":" + uniqueId;
    }
}


    