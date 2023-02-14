Feature: Testing API Delete Product

  @CapStone @Positive-Case @Product
  Scenario Outline: DELETE product with valid parameter id
    Given Delete product with valid parameter id <id>
    When Send request deleteProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema deleteProduct
    Examples:
      | id | statusCode | message                  |
      | 80 | 200        | "success delete product" |

  @CapStone @Negative-Case @Product
  Scenario Outline: DELETE product with invalid parameter id
    Given Delete product with invalid parameter <id>
    When Send request deleteProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    Examples:
      | id    | statusCode | message                      |
      | "abc" | 400        | "wrong product id parameter" |

  @CapStone @Negative-Case @Product
  Scenario Outline: DELETE product with invalid token
    Given Delete product with invalid token with id <id>
    When Send request deleteProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema deleteProduct
    Examples:
      | id | statusCode | message                  |
      | 80 | 401        | "invalid or expired jwt" |

