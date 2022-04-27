package scientificcalculatobackend;

import scientificcalculatobackend.IOCContainer.Container;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        try
        {
            var api = Container.GetUICommunicator();
            api.GetExpressionResult();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
