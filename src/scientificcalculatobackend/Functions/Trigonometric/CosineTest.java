package scientificcalculatobackend.Functions.Trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.Functions.Trigonometric.Cosine;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Rounding;

class CosineTest {
    private Cosine _cosine = Container.GetCosine();
    @Test
    void run()
    {
        double expected = 1.047197551;
        double actual = _cosine.Run(0.5, -1);
        actual = Rounding.RoundDouble(actual, 9);
        Assertions.assertEquals(expected, actual);
    }
}