package travel.system;

import java.time.LocalDateTime;

public class CarRide extends RoadTravel implements Reservable, Rentable {
    private String hirerName;

    public CarRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber, String hirerName) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
        this.hirerName = hirerName;
    }

    public CarRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
        this.hirerName = null;
    }

    public String getHirerName() {
        return hirerName;
    }

    public void setHirerName(String hirerName) {
        this.hirerName = hirerName;
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (this.getOccupiedSeats() + numberOfSeats > this.getSeats())
            throw new NoFreeSeatsException("Not enough free seats to reserve.");
        else this.setOccupiedSeats(this.getOccupiedSeats() + numberOfSeats);
    }

    @Override
    public void rent(String name) {
        this.setHirerName(name);
    }

    @Override
    public void print() {
        System.out.println("---Car Ride---");
        super.print();
        System.out.println("Hirer: " + this.getHirerName());
    }
}
