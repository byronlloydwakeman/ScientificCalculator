package scientificcalculatobackend;

import scientificcalculatobackend.BracketOperations.BracketIndexModel;

public class Replace
{
    public String ReplaceSubExpressionWithValue(String expression, String value, BracketIndexModel model, boolean isFunction)
    {
        String toReturn = "";
        //If the subExpression belongs to a function then we need to
        //return with brackets if not, without
        if(isFunction)
        {
            toReturn += expression.substring(0, model.OpeningBracketIndex + 1) + value
                    + expression.substring(model.ClosingBracketIndex);
        }
        else
        {
            toReturn += expression.substring(0, model.OpeningBracketIndex) + value
                    + expression.substring(model.ClosingBracketIndex + 1);
        }

        return toReturn;
    }

    public String ReplaceFunctionWithValue(String expression, String value, BracketIndexModel model)
    {
        //Check if the char before the bracket is a 'h', if so replace the 4 characters before the first brackets
        //to the index of the last bracket
        String toReturn = "";

        char charAt = expression.charAt(model.OpeningBracketIndex - 1);
        if(charAt == 'h')
        {
            toReturn = expression.substring(0, model.OpeningBracketIndex - 4) + value + expression.substring(model.ClosingBracketIndex + 1, expression.length());
        }
        else
        {
            toReturn = expression.substring(0, model.OpeningBracketIndex - 3) + value + expression.substring(model.ClosingBracketIndex + 1, expression.length());
        }

        return toReturn;
    }
}
