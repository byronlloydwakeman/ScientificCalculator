package scientificcalculatobackend.Functions.ExponentialsAndLogarithms;

import scientificcalculatobackend.Functions.IFunction;

public class Logarithm implements IFunction
{
    @Override
    public double Run(double value1, double value2)
    {
        return (Math.log(value2)) / (Math.log(value1));
    }
}
