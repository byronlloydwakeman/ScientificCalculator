package scientificcalculatobackend.Operators;

public class Addition implements IOperator{
    @Override
    public double Run(double value1, double value2)
    {
        return value1 + value2;
    }
}
