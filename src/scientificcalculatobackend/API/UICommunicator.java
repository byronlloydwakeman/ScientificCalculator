package scientificcalculatobackend.API;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import jsonserializer.JsonConverter;
import scientificcalculatobackend.API.Models.ResultModel;
import scientificcalculatobackend.ExpressionThread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class UICommunicator
{

    private HttpServer _server;
    private int _port = 8080;
    private String responseText = "";

    private void SendResult(HttpExchange exchange) throws IOException
    {
        exchange.sendResponseHeaders(200, responseText.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(responseText.getBytes());
        output.flush();
    }

    private String ConvertJsonStringToModel(String value)
    {
        String expression = "";
        //Create new JSON object to convert data
        Json json = new Json();
        //Converting the json string into a model
        try
        {
            expression = json.JsonStringToString(value);
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return expression;
    }

    private String GetPOSTData(HttpExchange exchange) throws IOException
    {
        //Get POST data from API
        var inputStream = exchange.getRequestBody();
        var inputStreamAsByteArray = inputStream.readAllBytes();
        String value = "";
        for (int i = 0; i < inputStreamAsByteArray.length; i++)
        {
            value += (char)inputStreamAsByteArray[i];
        }

        return value;
    }

    private String SolveGivenData(String expression, HttpExchange exchange)
    {
        String toReturn = "";
        ExpressionThread _expressionThread = new ExpressionThread();
        //Solving the value
        try
        {
             toReturn = String.valueOf(_expressionThread.Run(expression));
        }
        catch (Exception e)
        {
            responseText = "An error has occurred, " +
                    "please check the formatting of your brackets";
            try
            {
                SendResult(exchange);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        return toReturn;
    }

    public void GetExpressionResult() throws Exception
    {
        if(_server == null)
        {
            try
            {
                _server =  HttpServer.create(new InetSocketAddress(_port), 0);
                System.out.println("Server creation complete");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        _server.createContext("/api/getExpressionResult", (exchange -> {

            //If it's not GET
            if("POST".equals(exchange.getRequestMethod()))
            {
                responseText = "";
                System.out.println("Post request successfully received");

                //Get POST data from API
                String value = GetPOSTData(exchange);

                //Create string to hold expression value
                String expression = ConvertJsonStringToModel(value);

                responseText = SolveGivenData(expression, exchange);

                SendResult(exchange);

                System.out.println("Post request successfully responded");
            }
            else
            {
                exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
            }
            exchange.close();
        }));

        _server.setExecutor(null); // creates a default executor
        _server.start();
    }


}
