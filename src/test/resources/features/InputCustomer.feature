Feature: Testing API Input Customer

  Scenario: POST input customer with valid json
    Given Post inputCustomer with valid json
    When Send request inputCustomer
    Then Should return status code 201