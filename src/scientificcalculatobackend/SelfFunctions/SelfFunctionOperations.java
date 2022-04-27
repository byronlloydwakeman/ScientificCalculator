package scientificcalculatobackend.SelfFunctions;

import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.IOCContainer.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelfFunctionOperations
{
    private List<String> _listOfSelfFunctionNames = new ArrayList<>();
    private Map<String, ISelfFunction> _selfFunctionMap = new HashMap<>();

    public SelfFunctionOperations()
    {
        _selfFunctionMap.put("|", Container.GetAbsolute());
        _selfFunctionMap.put("!", Container.GetFactorial());
    }

    public String PerformSelfFunctionOperations(String expression, BracketIndexModel model)
    {
        //Get the subExpression
        String subExpression = expression.substring(model.OpeningBracketIndex + 1, model.ClosingBracketIndex);
        String selfFunctionName = subExpression.substring(subExpression.length() - 1);
        double operand = Double.parseDouble(subExpression.substring(0, subExpression.length() - 1));
        return String.valueOf(_selfFunctionMap.get(selfFunctionName).Run(operand));
    }

    public boolean IsSubExpressionSelfFunction(String expression, BracketIndexModel model)
    {
        //Loop through the string from the bracket and try to
        //find one of the Function names
        String subExpression = expression.substring(model.ClosingBracketIndex - 1, model.ClosingBracketIndex);
        if(_selfFunctionMap.containsKey(subExpression))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
