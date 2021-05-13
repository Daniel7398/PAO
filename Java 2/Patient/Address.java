ackage Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Address {
    private String Street, City, County;
    private int PostalCode;

    public Address(String Street, String City, String County, int PostalCode) {
        this.Street = Street;
        this.City = City;
        this.County = County;
        this.PostalCode = PostalCode;
    }

    public Address(Scanner in){
        this.read(in);
    }
    
    public Address(ResultSet in) throws SQLException {
        this.read(in);
    }

    public void read(Scanner in){
        System.out.println("Street: ");
        this.Street = in.nextLine();
        System.out.println("City: ");
        this.City = in.nextLine();
        System.out.println("County: ");
        this.County = in.nextLine();
        System.out.println("Postal code: ");
        this.PostalCode = Integer.parseInt(in.nextLine());
    }

    @Override
    public String toString() {
        return "{" +
                "Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", County='" + County + '\'' +
                ", postalCode=" + PostalCode +
                '}';
    }
    
    public String toCSV() {
        return Street +
                "," + City +
                "," + County+
                "," + PostalCode;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setCounty(String County) {
        this.County = County;
    }

    public void setPostalCode(int postalCode) {
        this.PostalCode = PostalCode;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getCounty() {
        return County;
    }

    public int getPostalCode() {
        return PostalCode;
    }
}