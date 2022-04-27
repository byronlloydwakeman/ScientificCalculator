package scientificcalculatobackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundingTest {

    @Test
    void roundDouble()
    {
        double expected = 4.123;
        double actual = Rounding.RoundDouble(4.1234, 3);
        Assertions.assertEquals(expected, actual);
    }
}