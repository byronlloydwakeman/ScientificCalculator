package scientificcalculatobackend.SelfFunctions;

import scientificcalculatobackend.Rounding;

public class Factorial implements ISelfFunction
{
    @Override
    public double Run(double value)
    {
        int sum = 1;
        value = Rounding.RoundDouble(value, 0);

        if(value == 0 || value == 1)
        {
            return 1;
        }

        for(int i = 2; i <= value; i++)
        {
            sum *= i;
        }

        return sum;
    }
}
