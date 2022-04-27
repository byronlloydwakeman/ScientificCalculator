package scientificcalculatobackend;

public class Convert
{
    public static double RadiansToDegrees(double radians)
    {
        return radians * (180 / Math.PI);
    }

    public static double DegreesToRadians(double degrees)
    {
        return degrees * (Math.PI / 180);
    }
}
