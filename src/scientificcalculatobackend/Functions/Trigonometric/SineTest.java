package scientificcalculatobackend.Functions.Trigonometric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.Functions.Trigonometric.Sine;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Rounding;

class SineTest {
    private Sine _sine = Container.GetSine();

    @Test
    void run()
    {
        double expected = 0.5236;
        double actual = _sine.Run(0.5, -1);
        actual = Rounding.RoundDouble(actual, 4);

        Assertions.assertEquals(expected, actual);
    }
}