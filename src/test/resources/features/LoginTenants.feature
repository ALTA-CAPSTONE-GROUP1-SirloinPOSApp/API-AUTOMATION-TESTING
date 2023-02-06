Feature: Testing API Login Tenant

  @CapStone @Positive-Case
  Scenario Outline: POST login tenant with valid email and password
    Given Post login with valid email and password
    When Send request login
    Then Should return status code 200
    And Response body page should be <id>, "<business_name>", "<email>", "<address>", "<phone_number>", "<token>" and "<message>"
    And Validate json schema login
    Examples:
      | id | business_name | email                   | address              | phone_number | token                                                                                                                       | message       |
      | 24 | TES QE TIM    | wirabint.9419@gmail.com | Jln. Kesuksesan No.9 | 081221531590 | eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjI0fQ.pI_POmwE6aheZHbhJE0nudMNJKl8Ug-30bNzp2r9_3o | login success |

