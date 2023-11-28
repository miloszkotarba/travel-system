package travel.system;

import java.time.LocalDateTime;

public class GovernmentFlight extends AirTravel implements Rentable {

    private String hirerName;

    public GovernmentFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber, String hirerName) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
        this.hirerName = hirerName;
    }

    public GovernmentFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
        this.hirerName = null;
    }

    public String getHirerName() {
        return this.hirerName;
    }

    public void setHirerName(String hirerName) {
        this.hirerName = hirerName;
    }

    @Override
    public void rent(String name) {
        this.setHirerName(name);
    }

    @Override
    public void print() {
        System.out.println("---Government Flight---");
        super.print();
        System.out.println("Hirer: " + this.getHirerName());
    }
}
