package scientificcalculatobackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.CustomExceptions.FirstOperandException;
import scientificcalculatobackend.CustomExceptions.OperatorIndexException;

class ExpressionTest
{
    private Expression _expression = new Expression();

    @Test
    void getSubString()
    {
        String expression = "(1 + 2) + 5";
        String expected = "1 + 2";

    }

    @Test
    void GetFirstOperand()
    {
        String expression = "1 + 2";
        String expected = "1";
        try {
            String actual = _expression.GetFirstOperand(expression, 0);
        } catch (FirstOperandException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findOperatorIndexValid()
    {
        String expression = "2 + 3";
        int expected = 2;
        int actual = 0;
        try
        {
            actual = _expression.FindOperatorIndex(expression);
        } catch (OperatorIndexException e)
        {
            e.printStackTrace();
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findOperatorIndexInvalidOperatorPosition()
    {
        boolean worked = false;
        String value = "+23";
        try
        {
            _expression.FindOperatorIndex(value);
        } catch (OperatorIndexException e) {
            worked = true;
        }
        Assertions.assertTrue(worked);
    }

    @Test
    void findOperatorIndexInvalidOperatorPosition2()
    {
        boolean worked = false;
        String value = "23+";
        try
        {
            _expression.FindOperatorIndex(value);
        } catch (OperatorIndexException e) {
            worked = true;
        }
        Assertions.assertTrue(worked);
    }

    @Test
    void isSubExpressionExpression()
    {
        String expression = "tan(0)";
        boolean expected = false;
        BracketIndexModel model = new BracketIndexModel();
        model.ClosingBracketIndex = 5;
        model.OpeningBracketIndex = 3;
        boolean actual = _expression.IsSubExpressionExpression(expression, model);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void performExpression()
    {
        String expression = "cos(tan(3.0 + 1.1))";
        String expected = "4.1";
        BracketIndexModel model = new BracketIndexModel();
        model.OpeningBracketIndex = 7;
        model.ClosingBracketIndex = 17;
        try {
            String actual = _expression.PerformExpression(expression, model);
            Assertions.assertEquals(expected, actual);
        } catch (OperatorIndexException e) {
            e.printStackTrace();
        } catch (FirstOperandException e) {
            e.printStackTrace();
        }

    }
}