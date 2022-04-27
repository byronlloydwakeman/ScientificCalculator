package scientificcalculatobackend.API;

public class Json
{
    public String JsonStringToString(String string) throws NoSuchFieldException, IllegalAccessException
    {
        String toReturn = new String();
        //As there will only be one data entry
        //get the data between the ':' and the '}'
        int colonIndex = -1;
        for (int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == ':')
            {
                colonIndex = i;
            }
            if(string.charAt(i) == '}')
            {
                toReturn = string.substring(colonIndex + 1, i);
            }
        }

        //Remove speech marks
        toReturn = toReturn.replaceAll("\"", "");
        return toReturn;
    }
}
