Feature: Testing API Edit Customer

  @CapStone @Positve-Case @Customer
  Scenario: PUT edit customer with valid parameter id
    Given Put editCustomer with valid id 32
    When Send request editCustomer
    Then Should return status code 200

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with invalid parameter id
    Given Put editCustomer with invalid id "abc"
    When Send request editCustomer
    Then Should return status code 200

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with valid json
    Given Put editCustomer with valid json and id 32
    When Send request editCustomer
    Then Should return status code 200

  @CapStone @Negative-Case @Customer
  Scenario: PUT edit customer with invalid json
    Given Put editCustomer with invalid json and id 32
    When Send request editCustomer
    Then Should return status code 400
