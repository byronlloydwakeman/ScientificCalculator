package scientificcalculatobackend.SelfFunctions;

public class Absolute implements ISelfFunction
{

    @Override
    public double Run(double value) {
        //Square it
        //Then return the square root
        value = value * value;
        return Math.sqrt(value);
    }
}
