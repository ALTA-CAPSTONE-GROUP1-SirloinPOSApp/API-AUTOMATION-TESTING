Feature: Testing API Add Customers

  Scenario: POST add customers with valid json
    Given Post addCustomers with valid json
    When Send request addCustomers
    Then Should return status code 201
    And Response body page should be <upc>, "<category>", "<product_name>", "<minimum_stock>", "<stock>", "<buying_price>", "<price>", "<product_image>" and "<suplier"
    And Validate json schema addProduct

  Scenario Outline: POST add product without input upc
    Given Post addProduct without upc
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                  |
      | 400        | "upc shouldn't be empty" |

  Scenario Outline: POST add product without input category
    Given Post addProduct without category
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                       |
      | 400        | "category shouldn't be empty" |

  Scenario Outline: POST add product without input product name
    Given Post addProduct without product name
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                           |
      | 400        | "product_name shouldn't be empty" |


  Scenario Outline: POST add product without input number of stock
    Given Post addProduct without number of stock
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                    |
      | 400        | "stock shouldn't be empty" |

  Scenario Outline: POST add product without input minimum stock
    Given Post addProduct without minimum stock
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                            |
      | 400        | "minimum stock shouldn't be empty" |

  Scenario Outline: POST add product without input price
    Given Post addProduct without price
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                    |
      | 400        | "price shouldn't be empty" |

  Scenario Outline: POST add product without input product image
    Given Post addProduct without product image
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                            |
      | 400        | "product image shouldn't be empty" |

  Scenario Outline: POST add product with input existing upc
    Given Post addProduct with existing upc
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message              |
      | 409        | "duplicated product" |

  Scenario Outline: POST add product with input existing product name
    Given Post addProduct with existing product name
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message              |
      | 409        | "duplicated product" |

  Scenario Outline: POST add product with invalid bearer token
    Given Post addProduct with invalid token
    When Send request addProduct
    Then Should return status code <statusCode>
    And Response body page should be <message>
    And Validate json schema addProduct negative case
    Examples:
      | statusCode | message                  |
      | 401        | "invalid or expired jwt" |

