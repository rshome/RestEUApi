package com.restapi.fixtures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.restapi.models.CountriesData;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.get;

public class Countries {

    private static String url;
    private static int count;
    private static int sCode;
    private static List<CountriesData> cList;

    @Test
    public void GetCountries() throws Exception
    {
        try
        {
            url = "http://restcountries.eu/rest/v1/all";

            // make get request to fetch json response from restcountries API using RestAssured GET method
            Response resp = get(url);

            //Fetching response in JSON then convert to JSON Array
            JSONArray jsonResponse = new JSONArray(resp.asString());

            count = jsonResponse.length(); // how many items in the array
            sCode = resp.statusCode();  // status code of 200 means successful response received

            //convert array to list, to match CountriesData c
            ObjectMapper mapper = new ObjectMapper();

            //create new arraylist to match CountriesData
            List<CountriesData> cDataList = new ArrayList<CountriesData>();

            Gson gson = new Gson();
            java.lang.reflect.Type listType = new TypeToken<List<CountriesData>>() {}.getType();

            cDataList = gson.fromJson(jsonResponse.toString(), listType);

            cList = cDataList;


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

    public static List<CountriesData> getcList()
    {
        return cList;
    }



}
