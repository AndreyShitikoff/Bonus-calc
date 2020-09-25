import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusMilesServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount,registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount,registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount,registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNoRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount,registered);

        assertEquals(expected, actual);
    }
}