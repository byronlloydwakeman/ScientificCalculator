package scientificcalculatobackend.CustomExceptions;

public class InvalidExponentException extends Exception
{
    public InvalidExponentException(String exponent)
    {
        super(String.format("%s is an invalid exponent", exponent));
    }
}
