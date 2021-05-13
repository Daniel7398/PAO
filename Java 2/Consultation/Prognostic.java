package Banking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Prognostic {
    final private String iNumbeR;
    final private double price;
    final private String description;
    final private Date creationDate;
    
    
    public Prognostic(String iNumbeR,double price, String description) throws Exception {

        if(amount <= 0)
            throw new Exception("The given price is too low!");
	
	this.iNumbeR = iNumbeR;
        this.price = price;
        this.description = description;
        this.creationDate = new Date();
    }
    
    
    public Prognostic(String iNumbeR, double price, String description, Date creationDate) throws Exception {
        this.iNumbeR = iNumbeR;
	this.price = price;
        this.description = description;
        this.creationDate = creationDate;
    }
    
    public Prognostic(ResultSet in) throws SQLException {
	this.iNumbeR = in.getString("iNumbeR");
        this.price = in.getDouble("price");
        this.description = in.getString("description");
        this.creationDate = in.getDate("creationDate");
    }
    
    @Override
    public String toString() {
        return "Prognostic{" +
		"iNumber=" + iNumbeR +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", creationDate=" + (new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss")).format(creationDate) +
                '}';
    }
    
    public String toCSV() {
        return iNumbeR +
		"," + price +
                "," + description +
                "," + (new SimpleDateFormat("yyyy-MM-dd h:m:i")).format(creationDate);
    }
    

   public String getINumbeR() {
        return iNumbeR;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}