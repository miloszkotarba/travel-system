package travel.system;

import java.time.LocalDateTime;

public class AirTravel extends Travel {
    private String planeNumber;

    public AirTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.planeNumber = planeNumber;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    @Override
    public void print() {
        System.out.println("Plane number: " + this.getPlaneNumber());
        super.print();
    }
}
