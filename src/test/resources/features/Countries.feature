Feature: GetCountriesCount
  In order to count the number of countries
  As a user with access to the RestCountries API
  I want to be told the number of countries in the API response

  @smoke
  Scenario Outline: Number of countries
    Given I generate a restful request
    When I receive a successful response <Response>
    Then the api response returns <Countries>

    Examples:
      | Response | Countries |
      | 200      | 250       |