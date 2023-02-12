Feature: Testing API Input Customer

  @CapStone @Positive-Case @Customer
  Scenario: POST input customer with valid json
    Given Post inputCustomer with valid json
    When Send request inputCustomer
    Then Should return status code 201

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with invalid json
    Given Post inputCustomer with invalid json
    When Send request inputCustomer
    Then Should return status code 400

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with registered email
    Given Post inputCustomer with registered email
    When Send request inputCustomer
    Then Should return status code 409

  @CapStone @Negative-Case @Customer
  Scenario: POST input customer with registered phone number
    Given Post inputCustomer with registered phone number
    When Send request inputCustomer
    Then Should return status code 409
