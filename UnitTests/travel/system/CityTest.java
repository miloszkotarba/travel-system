package travel.system;

import org.junit.jupiter.api.Test;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
    @Test
    void isTheSameCountry() {
        City city1 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city2 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        City city3 = new City("Prague", "Czech Republic", ZoneId.of("Europe/Prague"));
        City city4 = new City("Zgierz", "Poland", ZoneId.of("Europe/Warsaw"));

        assertFalse(city1.isTheSameCountry(city2));
        assertFalse(city1.isTheSameCountry(city3));
        assertTrue(city1.isTheSameCountry(city4));
    }

    @Test
    void isTheSameTime() {
        City city1 = new City("New York", "USA", ZoneId.of("America/New_York"));
        City city2 = new City("London", "UK", ZoneId.of("Europe/London"));
        City city3 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city4 = new City("Madrid", "Spain", ZoneId.of("Europe/Madrid"));


        assertFalse(city1.isTheSameTime(city2));
        assertFalse(city2.isTheSameTime(city4));
        assertTrue(city3.isTheSameTime(city4));
    }
}