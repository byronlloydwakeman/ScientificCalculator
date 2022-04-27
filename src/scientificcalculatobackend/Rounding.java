package scientificcalculatobackend;

public class Rounding
{

    public static double RoundDouble(double value, int places)
    {
        String stringValue = String.format("%." + places + "f", value);
        return Double.valueOf(stringValue);
    }
}
