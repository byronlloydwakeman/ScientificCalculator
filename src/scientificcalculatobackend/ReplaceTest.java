package scientificcalculatobackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.IOCContainer.Container;

class ReplaceTest {
    private Replace _replace = Container.GetReplace();
    @Test
    void replaceSubExpressionWithValue()
    {
        String expression = "cos(1 + 2)";
        String expected = "cos(3)";
        BracketIndexModel model = new BracketIndexModel();
        model.OpeningBracketIndex = 3;
        model.ClosingBracketIndex = 9;
        String actual = _replace.
                ReplaceSubExpressionWithValue(expression, "3", model, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ReplaceFunctionWithValue()
    {
        String expression = "cosh(0)";
        String expected = "1";
        BracketIndexModel model = new BracketIndexModel();
        model.OpeningBracketIndex = 4;
        model.ClosingBracketIndex = 6;
        String actual = _replace.ReplaceFunctionWithValue(expression, "1", model);
        Assertions.assertEquals(expected, actual);

    }
}