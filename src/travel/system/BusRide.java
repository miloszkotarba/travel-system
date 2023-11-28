package travel.system;

import java.time.LocalDateTime;

public class BusRide extends RoadTravel implements Reservable {
    public BusRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (this.getOccupiedSeats() + numberOfSeats > this.getSeats())
            throw new NoFreeSeatsException("Not enough free seats to reserve.");
        else this.setOccupiedSeats(this.getOccupiedSeats() + numberOfSeats);
    }

    @Override
    public void print() {
        System.out.println("---Bus Ride---");
        super.print();
    }
}
