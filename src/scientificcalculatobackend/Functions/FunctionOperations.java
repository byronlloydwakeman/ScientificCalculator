package scientificcalculatobackend.Functions;

import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.IOCContainer.Container;

import java.util.HashMap;
import java.util.Map;

public class FunctionOperations
{
    private Map<String, IFunction> _functionMap = new HashMap<>();

    public FunctionOperations()
    {
        _functionMap.put("exp", Container.GetExponential());
        _functionMap.put("log", Container.GetLogarithm());
        _functionMap.put("cos", Container.GetCosine());
        _functionMap.put("sin", Container.GetSine());
        _functionMap.put("tan", Container.GetTangent());
        _functionMap.put("cosh", Container.GetCosh());
        _functionMap.put("sinh", Container.GetSinh());
        _functionMap.put("tanh", Container.GetTanh());
    }

    public String PerformFunctionOperations(String expression, BracketIndexModel model)
    {
        //subExpression will be something like "cos(180, -1)"
        String subExpression = expression.substring(model.OpeningBracketIndex + 1, model.ClosingBracketIndex);
        String functionName = "";

        //Find function name
        if(expression.charAt(model.OpeningBracketIndex - 1) == 'h')
        {
            functionName = expression.substring(model.OpeningBracketIndex - 4, model.OpeningBracketIndex);
        }
        else
        {
            functionName = expression.substring(model.OpeningBracketIndex - 3, model.OpeningBracketIndex);
        }

        IFunction function = _functionMap.get(functionName);
        int commaIndex = subExpression.indexOf(',');
        double firstOperand = Double.valueOf(subExpression.substring(0, commaIndex));
        double secondOperand = Double.valueOf(subExpression.substring(commaIndex + 1, subExpression.length()));
        return String.valueOf(function.Run(firstOperand, secondOperand));
    }


    public boolean DoesBracketBelongToAFunction(String expression, BracketIndexModel indexModel)
    {
        //We have the index of the starting bracket
        //We just need to loop back through from that index
        //Is it hyperbolic
        if(expression.charAt(indexModel.OpeningBracketIndex - 1) == 'h')
        {
            //If it is then we need to get a string of the
            //previous 4 characters
            String hypString = expression.substring(indexModel.OpeningBracketIndex - 4, indexModel.OpeningBracketIndex);
            if(_functionMap.containsKey(hypString))
            {
                return true;
            }
        }

        String substring = expression.substring(indexModel.OpeningBracketIndex - 3, indexModel.OpeningBracketIndex);
        if(_functionMap.containsKey(substring))
        {
            return true;
        }

        return false;
    }
}
