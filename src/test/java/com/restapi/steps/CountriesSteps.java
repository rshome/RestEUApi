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

    @Given("^I generate a restful request$")
    public void iGenerateARestfulRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        countriesclass.GetCountries();
    }

    @When("^I receive a successful response (.*)$")
    public void iReceiveASuccessfulResponseResponse(int code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(code, countriesclass.getsCode() );
    }

    @Then("^the api response returns (.*)$")
    public void theApiResponseReturnsCountries(int countries) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(countries, countriesclass.getCount());
    }


}
