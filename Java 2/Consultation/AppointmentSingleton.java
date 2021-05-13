package Banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.AccessControlContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppointmentSingleton {

    private static AppointmentSingleton single_instance = null;

    private List<Appointment> appointments = new ArrayList<Appointment>();

    public static AppointmentSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new AppointmentSingleton();
        return single_instance;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
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
            System.out.println("No saved appointments!");
        }

        return columns;
    }

    public void loadFromCSV() {
        var columns = AppointmentSingleton.getCSVColumns("data/appointments.csv");
        for(var fields : columns){
            var newAppointment = new Appointment(
                    fields[0],
                    Double.parseDouble(fields[1]),
                    fields[2],
                    Integer.parseInt(fields[3])
            );
            appointments.add(newAppointment);
        }
        AppointmentFactory.incrementUniqueId(columns.size());
    }

    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/appointnments.csv");
            for(var appointment : this.appointments){
                writer.write(appointment.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}