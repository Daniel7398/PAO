package Consultation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FreeAppointment extends Appointment{
    private final Date appointmentDate;
    private final int priority;

    public FreeAppointment(String name, int patientId, String uniqueId) {
        super(name, patientId, uniqueId);


        this.appointmentDate = new Date();
        this.priority = 5;
    
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        this.endDate = c.getTime();
    
    }
    
    public FreeAppointment(String NumbeR, double price, String name, int patientId, Date startDate, Date endDate, int priority) {
        super(NumbeR, price, name, patientId);

        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
    }
    
    public FreeAppointment(ResultSet in) throws SQLException {
        super(in);
        this.startDate = in.getDate("startDate");
        this.endDate = in.getDate("endDate");
        this.priority = in.getInt("priority");
    }


    @Override
    public String toString() {
        return "FreeAppointment{" +
                "NumbeR='" + NumbeR + '\'' +
                ", pricet=" + price +
                ", name='" + name + '\'' +
                ", patientId=" + patientId +
                ", doctors=" + doctors +
                ", startDate=" + (new SimpleDateFormat("yyyy-MM-dd")).format(startDate) +
                ", endDate=" + (new SimpleDateFormat("yyyy-MM-dd")).format(endDate) +
                ", priority=" + priority +
                '}';
    }
    
    public String toCSV() {
        return NumbeR +
                "," + price +
                "," + name +
                "," + patientId +
                "," + doctors +
                "," + (new SimpleDateFormat("yyyy-MM-dd")).format(startDate) +
                "," + (new SimpleDateFormat("yyyy-MM-dd")).format(endDate) +
                "," + priority;
    }
    
     public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getPriority() {
        return priority;
    }

}