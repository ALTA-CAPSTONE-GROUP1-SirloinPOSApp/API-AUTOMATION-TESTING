Feature: Testing API Get Customer

  @CapStone @Positive-Case @Customer
  Scenario: Get display all customer list
    Given Get display all customer
    When Send request getCustomer
    Then Should return status code 200

  @CapStone @Positive-Case @Customer
  Scenario: Get display customer with id
    Given Get display customer with id 32
    When Send request getCustomer with id
    Then Should return status code 200

  @CapStone @Negative-Case @Customer
  Scenario: Get display customer with invalid id
    Given Get display customer with invalid id "abc"
    When Send request getCustomer with invalid id
    Then Should return status code 404