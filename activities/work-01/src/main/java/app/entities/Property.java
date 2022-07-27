package app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "properties")
public class Property {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String address;
    private double squaredMetersLand;
    private double squaredMetersBuilt;
    private int bathroomsAmount;
    private int parkingSpacesAmount;

    public Property(){
        super();
    }
    public Property(int id, String title, String address,
                    double squaredMetersBuilt, double squaredMetersLand,
                    int bathroomsAmount, int parkingSpacesAmount){
        this.id = id;
        this.title = title;
        this.address = address;
        this.squaredMetersBuilt = squaredMetersBuilt;
        this.squaredMetersLand = squaredMetersLand;
        this.bathroomsAmount = bathroomsAmount;
        this.parkingSpacesAmount = parkingSpacesAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquaredMetersLand() {
        return squaredMetersLand;
    }

    public void setSquaredMetersLand(double squaredMetersLand) {
        this.squaredMetersLand = squaredMetersLand;
    }

    public double getSquaredMetersBuilt() {
        return squaredMetersBuilt;
    }

    public void setSquaredMetersBuilt(double squaredMetersBuilt) {
        this.squaredMetersBuilt = squaredMetersBuilt;
    }

    public int getBathroomsAmount() {
        return bathroomsAmount;
    }

    public void setBathroomsAmount(int bathroomsAmount) {
        this.bathroomsAmount = bathroomsAmount;
    }

    public int getParkingSpacesAmount() {
        return parkingSpacesAmount;
    }

    public void setParkingSpacesAmount(int parkingSpacesAmount) {
        this.parkingSpacesAmount = parkingSpacesAmount;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", squaredMetersLand=" + squaredMetersLand +
                ", squaredMetersBuilt=" + squaredMetersBuilt +
                ", bathroomsAmount=" + bathroomsAmount +
                ", parkingSpacesAmount=" + parkingSpacesAmount +
                '}';
    }
}
