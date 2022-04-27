package scientificcalculatobackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.IOCContainer.Container;

class ExpressionThreadTest
{
    private ExpressionThread _thread = Container.GetExpressionThread();

    public ExpressionThreadTest()
    {
    }

    @Test
    void run()
    {
        String expression = "(1 + 2)";
        double expected = 1.0;
        try
        {
            double actual = _thread.Run(expression);
            Assertions.assertEquals(expected, actual);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}