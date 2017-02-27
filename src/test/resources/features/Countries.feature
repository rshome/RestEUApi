Feature: GetCountriesCount
  In order to count the number of countries
  As a user with access to the RestCountries API
  I want to be told the number of countries in the API response

  Scenario Outline: Number of countries
    Given I generate a restful request for countries
    When I receive a successful country response <Response>
    Then the api country response returns <Countries>

    Examples:
      | Response | Countries  |
      | 200      | 250        |


   Scenario Outline: Specific Country Details
     Given I generate a restful request for countries
     When I receive a successful country response
     Then the api country response for Index <Index> returns <Name>,<Capital>,<Population>

     Examples:
     | Index     | Name        | Capital      | Population    |
     | 0         | Afghanistan | Kabul        | 26023100      |
     | 10        | Argentina   | Buenos Aires | 43131966      |