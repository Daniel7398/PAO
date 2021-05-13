package Banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class FreeAppointmentSingleton {

    private static FreeAppointmentSingleton single_instance = null;

    final private AppointmentFactory appointemntFactory = new AppointmentFactory();
    private List<FreeAppointment> freeAppointments = new ArrayList<FreeAppointment>();


    public static FreeAppointmentSingleton getInstance() {
        if (single_instance == null)
            single_instance = new FreeAppointmentSingleton();
        return single_instance;
    }
    
    public void setFreeAppointments(List<FreeAppointment> freeAppointments) {
        this.freeAppointments = freeAppointments;
    }
    
    public List<FreeAppointment> getFreeAppointments() {
        return freeAppointments;
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
            System.out.println("No saved free appointments!");
        }

        return columns;
    }
    
    
    public void loadFromCSV() {
        try {
            var columns = FreeAppointmentSingleton.getCSVColumns("data/free_appointments.csv");
            for(var fields : columns){
                var newFreeAppointment = new FreeAppointment(
                        fields[0],
                        Double.parseDouble(fields[1]),
                        fields[2],
                        Integer.parseInt(fields[3]),
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[4]),
                        new SimpleDateFormat("yyyy-MM-dd").parse(fields[5]),
                        Integer.parseInt(fields[6])
                );
                freeAppointments.add(newFreeAppointment);
            }
            AppointmentFactory.incrementUniqueId(columns.size());
        }catch (ParseException e){
            System.out.println("Cannot load free appointments!");
        }

    }
    
    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/free_appointments.csv");
            for(var account : this.freeAppointments){
                writer.write(appointment.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}


