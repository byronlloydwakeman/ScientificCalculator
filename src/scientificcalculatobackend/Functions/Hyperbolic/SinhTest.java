package scientificcalculatobackend.Functions.Hyperbolic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Rounding;

import static org.junit.jupiter.api.Assertions.*;

class SinhTest {
    private Sinh _sinh = Container.GetSinh();
    @Test
    void run()
    {
        double expected = 4.78756118;
        double actual = _sinh.Run(60, -1);
        actual = Rounding.RoundDouble(expected, 8);
        Assertions.assertEquals(expected, actual);
    }
}