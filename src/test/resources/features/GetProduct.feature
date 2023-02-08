Feature: Testing API Get Product

  Scenario Outline: Get display all product list
    Given Get display all product
    When Send request getproduct
    Then Should return status code <statusCode>
    And Validate json schema getProduct
    Examples:
      | statusCode |
      | 200        |

  Scenario Outline: Get display product list by id
    Given Get display product by id <id>
    When Send request getproduct by id
    Then Should return status code <statusCode>
    And Response body should be <id>
    And Validate json schema getProduct by id
    Examples:
      | id | statusCode |
      | 68 | 200        |

  Scenario Outline: Get display product list by invalid
    Given Get display product by invalid "<id>"
    When Send request getproduct by invalid id
    Then Should return status code <statusCode>
    And Response body should be "<message>"
    Examples:
      | id  | statusCode | message                    |
      | abc | 400        | wrong product id parameter |

  Scenario Outline: Get display all product with valid token
    Given Get display all product with valid token
    When Send request getproduct
    Then Should return status code <statusCode>
    And Validate json schema getProduct
    Examples:
      | statusCode |
      | 200        |

  Scenario Outline: Get display all product with invalid token
    Given Get display all product with invalid token
    When Send request getproduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema getProduct negative case
    Examples:
      | statusCode | message                  |
      | 401        | "invalid or expired jwt" |






