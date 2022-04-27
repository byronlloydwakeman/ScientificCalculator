package scientificcalculatobackend.BracketOperations;

public class Brackets
{
    public int FindIndexOfNextClosingBracket(int openingIndex, String expression)
    {
        for(int i = openingIndex; i < expression.length(); i++)
        {
            //If we find a bracket, and it hasn't already been used
            if(expression.charAt(i) == ')')
            {
                return i;
            }
        }

        return -1;
    }

    public int FindIndexOfNextLastOpeningBracket(String expression)
    {
        for(int i = expression.length() - 1; i >= 0; i--)
        {
            if(expression.charAt(i) == '(')
            {
                return i;
            }
        }

        return -1;
    }

    public BracketIndexModel FindNextBracketIndexes(String expression)
    {
        //Find the index of the last opening bracket
        int nextOpeningIndex = FindIndexOfNextLastOpeningBracket(expression);
        var toReturn = new BracketIndexModel();
        //Check if there's another set of brackets
        if(nextOpeningIndex == -1)
        {
            toReturn.IsBracket = false;
            return toReturn;
        }

        int nextClosingIndexAfter = FindIndexOfNextClosingBracket(nextOpeningIndex, expression);

        toReturn.IsBracket = true;
        toReturn.ClosingBracketIndex = nextClosingIndexAfter;
        toReturn.OpeningBracketIndex = nextOpeningIndex;

        return toReturn;

    }
}
