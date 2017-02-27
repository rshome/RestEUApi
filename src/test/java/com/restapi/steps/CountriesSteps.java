package com.restapi.steps;

import com.restapi.fixtures.Countries;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by rshome on 22/02/2017.
 */
public class CountriesSteps {

    Countries countriesclass = new Countries();

    @Given("^I generate a restful request for countries$")
    public void iGenerateARestfulRequestForCountries() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        countriesclass.GetCountries();
    }

    @When("^I receive a successful country response (.*)$")
    public void iReceiveASuccessfulCountryResponseResponse(int code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(code, countriesclass.getsCode());
    }
    
    @Then("^the api country response returns (.*),(.*),(.*),(.*),(.*)$")
    public void theApiCountryResponseReturnsCountriesNameCapitalPopulation(int countries, int index, String name, String capital, int population) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(countries, countriesclass.getCount());

        //Validate a few values from response
        Assert.assertEquals(name, countriesclass.getcList().get(index).name);
        Assert.assertEquals(capital, countriesclass.getcList().get(index).capital);
        Assert.assertEquals(population, countriesclass.getcList().get(index).population);
    }
}
