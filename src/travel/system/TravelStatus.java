package travel.system;

import java.time.LocalDateTime;

public enum TravelStatus {
    COMPLETED, IN_PROGRESS, NOT_STARTED;

    public String getStatus() {
        return this.toString();
    }
    public static TravelStatus calculateStatus(LocalDateTime currentTime, LocalDateTime startTime, int duration) {
        if (currentTime.isBefore(startTime))
            return NOT_STARTED;
        else if (currentTime.isAfter(startTime.plusMinutes(duration)))
            return COMPLETED;
        else
            return IN_PROGRESS;
    }
}