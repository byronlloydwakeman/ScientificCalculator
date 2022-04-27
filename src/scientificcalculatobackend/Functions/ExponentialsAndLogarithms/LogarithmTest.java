package scientificcalculatobackend.Functions.ExponentialsAndLogarithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Rounding;

import static org.junit.jupiter.api.Assertions.*;

class LogarithmTest {
    private Logarithm _logarithm = Container.GetLogarithm();
    @Test
    void run()
    {
        double expected = 0.6989700043;
        double actual = _logarithm.Run(10, 5);
        actual = Rounding.RoundDouble(actual, 10);
        Assertions.assertEquals(expected, actual);
    }
}