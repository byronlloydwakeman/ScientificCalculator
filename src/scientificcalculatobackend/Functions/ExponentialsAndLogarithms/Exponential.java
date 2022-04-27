package scientificcalculatobackend.Functions.ExponentialsAndLogarithms;

import scientificcalculatobackend.Functions.IFunction;

public class Exponential implements IFunction
{
    @Override
    public double Run(double value1, double value2)
    {
        return Math.pow(value1, value2);
    }
}
