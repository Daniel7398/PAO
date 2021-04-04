package Consultation;

import Doctor.*;

import java.util.*;

public class Appointment implements Comparator<Prognostics> {
    protected String NumbeR;
    protected double price;
    String name;
    

    protected List<Prognostics> prognosticHistory = new ArrayList<>();
    protected List<Doctor> doctors = new ArrayList<>();

    private final Factory doctorFactory = new DoctorFactory();

    public Appointment(String name, String NumbeR) {
        this.name = name;
        this.NumbeR = NumbeR;
        this.price = 0;
    }

    public Prognostics createPrognostic(Appointment appointment, String description) throws Exception {
        Prognostic newPrognostic = new Prognostic(appointment, description);

        appointment.prognosticHistory.add(newPrognostic);

        return newPrognostic;
    }



    public List<Prognostic> getPrognosticHistory() {
        return prognosticHistory;
    }

    public int compare(Prognostic prognostic1, Prognostic prognostic2){
        return prognostic1.getCreationDate().compareTo(prognostic2.getCreationDate());
    }

    public List<Prognostic> getPrognosticHistory(int year) {
        /// Filtered and sorted list, comparator implemented
        List<Prognostic> filteredPrognostics = new ArrayList<>();
        for(var prognostic: prognosticHistory)
            if(prognostic.getCreationDate().getYear()==year)
                filteredPrognostics.add(prognostic);
        filteredPrognostics.sort(this);
        return filteredPrognostics;
    }

    public List<Prognostic> getPrognosticHistory(int year, int month) {
        /// Filtered and sorted list, comparator implemented
        List<Prognostic> filteredPrognostics = new ArrayList<>();
        for(var prognostic: prognosticHistory)
            if(prognostic.getCreationDate().getYear()==year && prognostic.getCreationDate().getMonth()==month)
                filteredPrognostics.add(prognostic);
        filteredPorgnostics.sort(this);
        return filteredPrognostics;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }


    public String getNumbeR() {
        return NumbeR;
    }



    @Override
    public String toString() {
        return "{" +
                "NumbeR='" + NumbeR + '\'' +
                ", Name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

    