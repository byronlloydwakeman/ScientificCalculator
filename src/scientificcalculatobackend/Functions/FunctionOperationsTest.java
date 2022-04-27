package scientificcalculatobackend.Functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.IOCContainer.Container;

class FunctionOperationsTest
{
    private FunctionOperations _function = Container.GetFunctionOperations();

    @Test
    void doesBracketBelongToAFunction()
    {
        String expression = "tan(cos(0))";
        boolean expected = true;
        var BracketIndexModel = new BracketIndexModel();
        BracketIndexModel.OpeningBracketIndex = 3;
        boolean actual = _function.DoesBracketBelongToAFunction(expression, BracketIndexModel);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void PerformFunctionOperations()
    {
        String expression = "tan(sinh(0 , 1))";
        BracketIndexModel model = new BracketIndexModel();
        model.OpeningBracketIndex = 8;
        model.ClosingBracketIndex = 14;
        String expected = "0";
        String actual = _function.PerformFunctionOperations(expression, model);

    }
}