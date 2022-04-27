package scientificcalculatobackend;

import scientificcalculatobackend.BracketOperations.BracketIndexModel;
import scientificcalculatobackend.CustomExceptions.FirstOperandException;
import scientificcalculatobackend.CustomExceptions.OperatorIndexException;
import scientificcalculatobackend.IOCContainer.Container;
import scientificcalculatobackend.Operators.*;

import java.util.HashMap;
import java.util.Map;

public class Expression
{
    private Map<String, IOperator> _operatorMap = new HashMap<>();

    public Expression()
    {
        _operatorMap.put("+", Container.GetAddition());
        _operatorMap.put("-", Container.GetSubtraction());
        _operatorMap.put("*", Container.GetMultiplication());
        _operatorMap.put("/", Container.GetDivision());
    }

    private boolean ValidOperatorIndex(int index, int expressionLength)
    {
        //The default value of the operator index is one, which in itself isn't valid
        //It's value cannot be 0, the length of the string or any number greater than
        if(index == 0 || index >= expressionLength - 1)
        {
            return false;
        }
        return true;
    }

    //Tested
    public int FindOperatorIndex(String expression) throws OperatorIndexException
    {
        //Search through the string to find the operation
        int operatorIndex = 0;
        for(int i = 0; i < expression.length(); i++)
        {
            if(_operatorMap.containsKey(String.valueOf(expression.charAt(i))))
            {
                operatorIndex = i;
            }
        }

        if(!ValidOperatorIndex(operatorIndex, expression.length()))
        {
            throw new OperatorIndexException("Invalid operator index");
        }

        return operatorIndex;
    }

    public boolean ValidFirstOperand(String subExpression, int operatorIndex)
    {
        //Check that the index is within range
        if(operatorIndex > subExpression.length() - 1 || operatorIndex < 0)
        {
            return false;
        }
        return true;
    }

    //Tested
    public String GetFirstOperand(String subExpression, int operatorIndex) throws FirstOperandException
    {
        String operand = subExpression.substring(0, operatorIndex);

        if(!ValidFirstOperand(subExpression, operatorIndex))
        {
            throw new FirstOperandException("Invalid expression" + subExpression + "or operator index: " + operatorIndex);
        }

        return operand;
    }

    public boolean IsSubExpressionExpression(String expression, BracketIndexModel model)
    {
        //Loop through the string from the bracket and try to
        //find one of the Function names
        String subExpression = expression.substring(model.OpeningBracketIndex + 1, model.ClosingBracketIndex);
        for(int i = 0; i < subExpression.length(); i++)
        {
            String a = String.valueOf(subExpression.charAt(i));
            int commaIndex = subExpression.indexOf(',');
            if(commaIndex != -1)
            {
                return false;
            }
            if(_operatorMap.containsKey(a))
            {
                return true;
            }
        }
        return false;
    }

    public String PerformExpression(String expression, BracketIndexModel model) throws OperatorIndexException, FirstOperandException {
        String subExpression = expression.substring(model.OpeningBracketIndex + 1, model.ClosingBracketIndex);
        subExpression = subExpression.replaceAll("\\)", "");
        subExpression = subExpression.replaceAll("\\(", "");

        //Validated
        int operatorIndex = FindOperatorIndex(subExpression);
        //Validated
        String operand1 = GetFirstOperand(subExpression, operatorIndex);
        //Validated
        String operand2 = subExpression.substring(operatorIndex + 1);
        char operationChar = subExpression.charAt(operatorIndex);
        //Needs validation
        IOperator operation = _operatorMap.get(Character.toString(operationChar));
        return String.valueOf(operation.Run(Double.parseDouble(operand1), Double.parseDouble(operand2)));
    }

    public String PerformExpression(String subExpression) throws OperatorIndexException, FirstOperandException
    {
        //Validated
        int operatorIndex = FindOperatorIndex(subExpression);
        //Validated
        String operand1 = GetFirstOperand(subExpression, operatorIndex);
        //Validated
        String operand2 = subExpression.substring(operatorIndex + 1);
        char operationChar = subExpression.charAt(operatorIndex);
        //Needs validation
        IOperator operation = _operatorMap.get(Character.toString(operationChar));
        return String.valueOf(operation.Run(Double.parseDouble(operand1), Double.parseDouble(operand2)));
    }

    public boolean IsSubExpressionExpression(String subExpression)
    {
        boolean b;
        for(int i = 0; i < subExpression.length(); i++)
        {
            String a = String.valueOf(subExpression.charAt(i));
            b = _operatorMap.containsKey(a);
            if(b)
            {
                return true;
            }
        }
        return false;
    }
}
