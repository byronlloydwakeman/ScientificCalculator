package scientificcalculatobackend;

import scientificcalculatobackend.BracketOperations.Brackets;
import scientificcalculatobackend.Functions.FunctionOperations;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.SelfFunctions.SelfFunctionOperations;

public class ExpressionThread
{
    private Brackets _bracketIndexModel = Container.GetBrackets();
    private FunctionOperations _functionOperations = Container.GetFunctionOperations();
    private SelfFunctionOperations _selfFunctionOperations = Container.GetSelfFunctionOperations();
    private Replace _replace = Container.GetReplace();
    private Expression _expression = Container.GetExpression();

    public double Run(String expressionParameter) throws Exception
    {
        String expression = expressionParameter;
        expression = expression.replaceAll("\\s+", "");

        //Find most inner set of bracket and set it to a
        //BracketIndexModel variable
        var BracketModel = _bracketIndexModel.FindNextBracketIndexes(expression);

        //While loop which checks the value of IsBracket
        while(BracketModel.IsBracket)
        {
            //Is the brackets from a self function?
            if(_selfFunctionOperations.IsSubExpressionSelfFunction(expression, BracketModel))
            {
                String value = _selfFunctionOperations.PerformSelfFunctionOperations(expression, BracketModel);
                expression = _replace.ReplaceSubExpressionWithValue(expression, value, BracketModel, false);
                BracketModel = _bracketIndexModel.FindNextBracketIndexes(expression);
                continue;
            }
            //This means the brackets are from a regular expression
            else if(_expression.IsSubExpressionExpression(expression, BracketModel))
            {
                String value = _expression.PerformExpression(expression, BracketModel);
                expression = _replace.ReplaceSubExpressionWithValue(expression, value, BracketModel, false);
                BracketModel = _bracketIndexModel.FindNextBracketIndexes(expression);
                continue;
            }
            //Is the brackets from a function
            else if(_functionOperations.DoesBracketBelongToAFunction(expression, BracketModel))
            {
                String value = _functionOperations.PerformFunctionOperations(expression, BracketModel);
                expression = _replace.ReplaceFunctionWithValue(expression, value, BracketModel);
                BracketModel = _bracketIndexModel.FindNextBracketIndexes(expression);
                continue;
            }
        }

        //Check if there's still an expression left
        if(_expression.IsSubExpressionExpression(expression))
        {
            String value = _expression.PerformExpression(expression);
            expression = value;
        }

        return Double.parseDouble(expression);
    }
}
