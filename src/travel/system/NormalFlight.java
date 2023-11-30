package travel.system;

import java.time.LocalDateTime;

public class NormalFlight extends AirTravel implements Reservable {

    public NormalFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
    }
    @Override
    public void print() {
        System.out.println("---Normal Flight---");
        super.print();
    }
}
