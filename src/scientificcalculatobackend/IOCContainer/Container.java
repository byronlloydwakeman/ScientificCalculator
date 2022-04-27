package scientificcalculatobackend.IOCContainer;

import scientificcalculatobackend.API.UICommunicator;
import scientificcalculatobackend.BracketOperations.Brackets;
import scientificcalculatobackend.Expression;
import scientificcalculatobackend.ExpressionThread;
import scientificcalculatobackend.Functions.ExponentialsAndLogarithms.Exponential;
import scientificcalculatobackend.Functions.ExponentialsAndLogarithms.Logarithm;
import scientificcalculatobackend.Functions.FunctionOperations;
import scientificcalculatobackend.Functions.Hyperbolic.Cosh;
import scientificcalculatobackend.Functions.Hyperbolic.Sinh;
import scientificcalculatobackend.Functions.Hyperbolic.Tanh;
import scientificcalculatobackend.Functions.Trigonometric.Cosine;
import scientificcalculatobackend.Functions.Trigonometric.Sine;
import scientificcalculatobackend.Functions.Trigonometric.Tangent;
import scientificcalculatobackend.Operators.Addition;
import scientificcalculatobackend.Operators.Division;
import scientificcalculatobackend.Operators.Multiplication;
import scientificcalculatobackend.Operators.Subtraction;
import scientificcalculatobackend.Replace;
import scientificcalculatobackend.SelfFunctions.Absolute;
import scientificcalculatobackend.SelfFunctions.Factorial;
import scientificcalculatobackend.SelfFunctions.SelfFunctionOperations;

public class Container
{
    public static ExpressionThread GetExpressionThread()
    {
        return new ExpressionThread();
    }

    public static Expression GetExpression()
    {
        return new Expression();
    }

    public static Addition GetAddition()
    {
        return new Addition();
    }

    public static Division GetDivision()
    {
        return new Division();
    }

    public static Subtraction GetSubtraction()
    {
        return new Subtraction();
    }

    public static Multiplication GetMultiplication()
    {
        return new Multiplication();
    }

    public static UICommunicator GetUICommunicator() throws Exception { return new UICommunicator(); }

    public static Sine GetSine()
    {
        return new Sine();
    }

    public static Cosine GetCosine()
    {
        return new Cosine();
    }

    public static Tangent GetTangent()
    {
        return new Tangent();
    }

    public static Sinh GetSinh()
    {
        return new Sinh();
    }

    public static Cosh GetCosh()
    {
        return new Cosh();
    }

    public static Tanh GetTanh()
    {
        return new Tanh();
    }

    public static Exponential GetExponential() {
        return new Exponential();
    }

    public static Logarithm GetLogarithm() { return new Logarithm(); }

    public static Absolute GetAbsolute() { return new Absolute(); }

    public static Factorial GetFactorial() { return new Factorial();}

    public static Brackets GetBrackets() { return new Brackets();}

    public static FunctionOperations GetFunctionOperations() {return new FunctionOperations();}

    public static SelfFunctionOperations GetSelfFunctionOperations()
    {
        return new SelfFunctionOperations();
    }

    public static Replace GetReplace()
    {
        return new Replace();
    }

}
