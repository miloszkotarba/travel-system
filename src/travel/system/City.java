package travel.system;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class City {
    private String name;
    private String country;
    private ZoneId zoneId;

    public City(String name, String country, ZoneId zoneId) {
        this.name = name;
        this.country = country;
        this.zoneId = zoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public boolean isTheSameCountry(City city2) {
        return this.getCountry().equals(city2.getCountry());
    }

    public boolean isTheSameTime(City otherCity) {
        LocalDateTime thisCityTime = LocalDateTime.now(this.getZoneId()).truncatedTo(ChronoUnit.SECONDS); //ucina do sekund
        LocalDateTime otherCityTime = LocalDateTime.now(otherCity.getZoneId()).truncatedTo(ChronoUnit.SECONDS);
        return thisCityTime.equals(otherCityTime);
    }
}
