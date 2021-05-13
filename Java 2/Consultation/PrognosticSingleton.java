package Banking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PrognosticSingleton {

    private static PrognosticSingleton single_instance = null;

    final private AppointmentFactory appointmentFactory = new AppointmentFactory();
    private List<Prognostic> prognostics = new ArrayList<Prognostic>();
    
     public static PrognosticSingleton getInstance()
    {
        if (single_instance == null)
            single_instance = new PrognosticSingleton();
        return single_instance;
    }

    public void setPrognostics(List<Prognostic> prognostics) {
        this.prognostics = prognostics;
    }

    public List<Prognostic> getPrognostics() {
        return prognostics;
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
            System.out.println("No saved prognostics!");
        }

        return columns;
    }
    
    public void loadFromCSV() {
        try {
            var columns = PrognosticSingleton.getCSVColumns("data/prognostics.csv");
            for(var fields : columns){
                var newPrognostic = new Prognostic(
                        fields[0],
                        Double.parseDouble(fields[1]),
                        fields[2],
                        new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss").parse(fields[4])
                );
                prognostics.add(newPrognostic);
            }
        }catch (ParseException e){
            System.out.println("Cannot load prognostics! - parse exception");
        } catch (Exception e) {
            System.out.println("Cannot parse prognostic! - invalid format");
        }
    }
    
    public void dumpToCSV(){
        try{
            var writer = new FileWriter("data/prognostics.csv");
            for(var prognostic : this.prognostics){
                writer.write(prognostic.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}