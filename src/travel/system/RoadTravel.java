package travel.system;

import java.time.LocalDateTime;

public class RoadTravel extends Travel {
    private String registrationNumber;

    public RoadTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public void print() {
        System.out.println("Registration number: " + this.getRegistrationNumber());
        super.print();
    }
}
