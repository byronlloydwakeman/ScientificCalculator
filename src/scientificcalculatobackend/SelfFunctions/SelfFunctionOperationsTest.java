package scientificcalculatobackend.SelfFunctions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.IOCContainer.Container;

class SelfFunctionOperationsTest
{
    private SelfFunctionOperations _selfFunctionOperations = Container.GetSelfFunctionOperations();


    @Test
    void isSubExpressionSelfFunction()
    {
        String expression = "cos(-233|)";
        boolean expected = true;
        BracketIndexModel model = new BracketIndexModel();
        model.OpeningBracketIndex = 3;
        model.ClosingBracketIndex = 9;
        boolean actual = _selfFunctionOperations.IsSubExpressionSelfFunction(expression, model);
        Assertions.assertEquals(expected, actual);
    }
}