package com.restapi.fixtures;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.get;

public class Countries {

    private static String url;
    private static int count;
    private static int sCode;

    @Test
    public static void GetCountries() throws Exception
    {
        try {
            url = "http://restcountries.eu/rest/v1/all";

            // make get request to fetch json response from restcountries API using RestAssured get method
            Response resp = get(url);

            //Fetching response in JSON then convert to string
            JSONArray jsonResponse = new JSONArray(resp.asString());

            count = jsonResponse.length();
            sCode = resp.statusCode();
        }
        catch (Exception e)
        {
            System.out.println("There is an error connecting to the API " + e);
            e.getStackTrace();
        }
    }

    public static int getsCode() {
        return sCode;
    }

    public static int getCount() {
        return count;
    }
}
