package scientificcalculatobackend.Functions.Hyperbolic;

import scientificcalculatobackend.Functions.IFunction;

public class Tanh implements IFunction
{
    @Override
    public double Run(double value1, double value2)
    {
        //Find the value of the function
        double toReturn = Math.tanh(value1);
        //Cases for the exponential parameter
        if(value2 == 0)
        {
            return 1;
        }
        else if(value2 == -1)
        {
            return Inverse(value1);
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

    private double Inverse(double value)
    {
        return 0.5 * Math.log((1 - value) / (1 + value));
    }
}
