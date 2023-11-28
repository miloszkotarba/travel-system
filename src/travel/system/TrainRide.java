package travel.system;

import java.time.LocalDateTime;

public class TrainRide extends RailwayTravel implements Reservable{

    public TrainRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, trainNumber);
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (this.getOccupiedSeats() + numberOfSeats > this.getSeats())
            throw new NoFreeSeatsException("Not enough free seats to reserve.");
        else this.setOccupiedSeats(this.getOccupiedSeats() + numberOfSeats);
    }

    @Override
    public void print() {
        System.out.println("---Train Ride---");
        super.print();
    }
}
