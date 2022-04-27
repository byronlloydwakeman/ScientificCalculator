package scientificcalculatobackend.Functions.Trigonometric;

import scientificcalculatobackend.Functions.IFunction;

public class Tangent implements IFunction
{
    @Override
    public double Run(double value1, double value2)
    {
        //Find the value of the function
        double toReturn = Math.tan(value1);
        //Cases for the exponential parameter
        if(value2 == 0)
        {
            return 1;
        }
        else if(value2 == -1)
        {
            return Math.atan(value1);
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
