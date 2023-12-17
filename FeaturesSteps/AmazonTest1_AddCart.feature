Feature: Register User Search iphone, Select and Store Price, add to cart.

Scenario: Register User Search iphone, Select and Store Price, add to cart.
    Given User Launch browser
    When User opens URL "https://www.amazon.in/"
    And I wait for 5 seconds
    And Click on SignIn Button to enter credentials
    And I wait for 5 seconds
    And Enter mobile number as "+919518970698" & click on continue
    And Enter password as "Sachin@007" & click on Sign In
    And I wait for 5 seconds
    Then Search phone as "iphone" & click "iphone 15 pro"
    And I wait for 5 seconds
    And Click on iphone & store its price
    And I wait for 5 seconds
    And Click on Add to cart
    And I wait for 5 seconds
    And Validate iphone is added in cart or not
    And I wait for 5 seconds
    And close the browser