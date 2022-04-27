package scientificcalculatobackend.Functions.Trigonometric;

import scientificcalculatobackend.CustomExceptions.InvalidExponentException;
import scientificcalculatobackend.Functions.IFunction;

import java.math.BigDecimal;

public class Sine implements IFunction
{
    @Override
    public double Run(double value1, double value2)
    {
        //Find the value of the function
        double toReturn = Math.sin(value1);
        //Cases for the exponential parameter
        if(value2 == 0)
        {
            return 1;
        }
        else if(value2 == -1)
        {
            return Math.asin(value1);
        }
        else if(value2 > 0)
        {
            return Math.pow(toReturn, value2);
        }
        else
        {
            return 1 / Math.pow(toReturn, value2);
        }

    }
}
