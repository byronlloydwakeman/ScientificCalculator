package scientificcalculatobackend.Functions.ExponentialsAndLogarithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Rounding;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialTest {

    private Exponential _exponential = Container.GetExponential();
    @Test
    void run()
    {
        double expected = 0.5;
        double actual = _exponential.Run(2, -1);
        actual = Rounding.RoundDouble(actual, 9);
        Assertions.assertEquals(expected, actual);
    }
}