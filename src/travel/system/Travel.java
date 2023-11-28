package travel.system;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Travel {
    private LocalDateTime startTime;
    private int duration;
    private City startCity;
    private City endCity;
    private int seats;
    private int occupiedSeats;

    private TravelStatus status;

    private enum TravelStatus {
        COMPLETED, IN_PROGRESS, NOT_STARTED
    }

    public Travel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats) {
        this.startTime = startTime;
        this.duration = duration;
        this.startCity = startCity;
        this.endCity = endCity;
        this.seats = seats;
        this.occupiedSeats = occupiedSeats;
        this.updateStatus();
    }

    public void updateStatus() {
        LocalDateTime currentTime = LocalDateTime.now();

        if (currentTime.isBefore(this.getStartTime()))
            status = TravelStatus.NOT_STARTED;

        else if (currentTime.isAfter(startTime.plusMinutes(this.getDuration())))
            status = TravelStatus.COMPLETED;

        else
            status = TravelStatus.IN_PROGRESS;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public String getStatus() {
        updateStatus();
        return this.status.toString();
    }

    public void print() {
        ZonedDateTime departureZonedDateTime = ZonedDateTime.of(this.getStartTime(), this.getStartCity().getZoneId());
        ZonedDateTime arrivalZonedDateTime = departureZonedDateTime.withZoneSameInstant(this.getStartCity().getZoneId()).plusMinutes(this.getDuration());
        ZonedDateTime arrivalZonedDateTimeDestination = departureZonedDateTime.withZoneSameInstant(this.getEndCity().getZoneId()).plusMinutes(this.getDuration());

        System.out.println("Seats: " + this.getOccupiedSeats() + "/" + this.getSeats());
        System.out.println("START: " + this.getStartCity().getName() + " " + greenText(String.valueOf(departureZonedDateTime)));
        System.out.println("END: " + this.getEndCity().getName() + " " + greenText(String.valueOf(arrivalZonedDateTime)) + " " + arrivalZonedDateTimeDestination);
    }

    private String greenText(String text) {
        return "\u001B[32m" + text + "\u001B[0m"; // Dodaje kod kolorowania na zielono i resetuje kolor
    }

    public boolean isNational() {
        return Objects.equals(this.getStartCity().getCountry(), this.getEndCity().getCountry());
    }

    public boolean doesChangeDate() {
        ZoneId startZone = this.getStartCity().getZoneId();
        ZoneId endZone = this.getEndCity().getZoneId();

        LocalDate startDate = this.getStartTime().atZone(startZone).toLocalDate();
        LocalDate endDate = this.getStartTime().plusMinutes(this.getDuration()).atZone(endZone).toLocalDate();

        return !startDate.isEqual(endDate);
    }

}