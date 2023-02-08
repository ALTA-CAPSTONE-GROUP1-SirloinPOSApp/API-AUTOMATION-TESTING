Feature: Testing API Update Product

  Scenario Outline: PUT update product with valid parameter id
    Given Put updateProduct with valid parameter <id>
    When Send request updateProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema updateProduct
    Examples:
      | id | statusCode | message                  |
      | 68 | 201        | "success update product" |

  Scenario Outline: PUT update product with valid json
    Given Put updateProduct with valid parameter <id>
    When Send request updateProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema updateProduct
    Examples:
      | id | statusCode | message                  |
      | 68 | 201        | "success update product" |

  Scenario Outline: PUT update product with invalid parameter id
    Given Put updateProduct with invalid parameter "<id>"
    When Send request updateProduct
    Then Should return status code <statusCode>
    Examples:
      | id  | statusCode |
      | abc | 400        |

  Scenario Outline: PUT update product with valid token
    Given Put updateProduct with valid token and id <id>
    When Send request updateProduct
    Then Should return status code <statusCode>
    And Response body should be <message>
    And Validate json schema updateProduct
    Examples:
      | id | statusCode | message                  |
      | 78 | 201        | "success update product" |

  Scenario Outline: PUT update product with invalid token
    Given Put updateProduct with invalid token and id <id>
    When Send request updateProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    Examples:
      | id | statusCode | message                  |
      | 78 | 401        | "invalid or expired jwt" |

  Scenario: PUT update product with invalid json
    Given Put updateProduct with invalid json and id 78
    When Send request updateProduct
    Then Should return status code 400

