package scientificcalculatobackend.CustomExceptions;

public class FirstOperandException extends Exception
{
    public FirstOperandException(String errorMessage)
    {
        super(errorMessage);
    }
}
