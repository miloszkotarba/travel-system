package travel.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.ZoneId;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {
    private static final LocalDateTime DATE_1 = LocalDateTime.of(2023, Month.JANUARY, 1, 12, 0);
    private static final LocalDateTime DATE_2 = LocalDateTime.of(2023, Month.SEPTEMBER, 20, 18, 0);

    @Test
    void isNational() {
        City city1 = new City("London", "UK", ZoneId.of("Europe/London"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city3 = new City("Glasgow", "UK", ZoneId.of("Europe/London"));
        City city4 = new City("Barcelona", "Spain", ZoneId.of("Europe/Madrid"));

        Travel nationalTravel = new Travel(LocalDateTime.now(), 0, city1, city3, 0, 0);
        Travel internationalTravel = new Travel(LocalDateTime.now(), 0, city2, city4, 0, 0);

        assertTrue(nationalTravel.isNational());
        assertFalse(internationalTravel.isNational());
    }


    @Test
    @DisplayName("doesChangeDate() - check if date between departure and arrival is different.")
    void doesChangeDate() {
        City city1 = new City("London", "UK", ZoneId.of("Europe/London"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));
        City city3 = new City("Moskwa", "Russia", ZoneId.of("Europe/Moscow"));

        Travel sameDayTravel = new Travel(DATE_1, 120, city1, city2, 0, 0);
        Travel zeroDurationTravel = new Travel(DATE_2, 400, city2, city3, 0, 0);

        assertFalse(sameDayTravel.doesChangeDate());
        assertTrue(zeroDurationTravel.doesChangeDate());
    }

    @Test
    void reserve() {
        City city1 = new City("Berlin", "Germany", ZoneId.of("Europe/Berlin"));
        City city2 = new City("Warsaw", "Poland", ZoneId.of("Europe/Warsaw"));

        Travel travel = new Travel(LocalDateTime.now(), 0, city1, city2, 20, 15);

        try {
            travel.reserve(2);
        } catch (NoFreeSeatsException e) {
            fail("Error: " + e.getMessage());
        }

        assertThrows(NoFreeSeatsException.class, () -> travel.reserve(16));
    }
}