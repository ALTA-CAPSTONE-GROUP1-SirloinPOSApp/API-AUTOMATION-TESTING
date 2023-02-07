Feature: Testing API Add Product

  Scenario: POST add product with valid input
    Given Post addProduct with valid json and token
    When Send request addProduct
    Then Should return status code 201