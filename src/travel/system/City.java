package travel.system;

import java.time.ZoneId;

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
}
