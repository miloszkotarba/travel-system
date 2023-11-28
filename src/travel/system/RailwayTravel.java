package travel.system;

import java.time.LocalDateTime;

public class RailwayTravel extends Travel {
    private String trainNumber;

    public RailwayTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Override
    public void print() {
        System.out.println("Train number: " + this.getTrainNumber());
        super.print();
    }
}
