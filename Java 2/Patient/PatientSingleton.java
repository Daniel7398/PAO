package Patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PatientSingleton {

    private static PatientSingleton single_instance = null;

    final private PatientFactory patientFactory = new PatientFactory();
    private List<Patient> patients = new ArrayList<Patient>();
    
     public static PatientSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new PatientSingleton();
        return single_instance;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    private static List<String[]> getCSVColumns(String fileName){

        List<String[]> columns = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fileName))) {

            String line;

            while((line = in.readLine()) != null ) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("No saved patients!");
        }

        return columns;
    }
    
    
    public void loadFromCSV() {
        try{
            var columns = PatientSingleton.getCSVColumns("data/patients.csv");
            for(var fields : columns){
                var newPatient = new Patient(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[4]),
                        fields[5],
                        fields[6],
                        new Address(fields[7], fields[8], fields[9], Integer.parseInt(fields[10]))
                );
                patients.add(newPatient);
            }
            PatientFactory.incrementUniqueId(columns.size());
        }catch (ParseException e){
            System.out.println(e.toString());
        }

    }
    
     public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/patients.csv");
            for(var customer : this.patients){
                writer.write(customer.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }


}