Feature: Register User Search iphone, apply filter and validate filters.

Scenario: Register User Search iphone, apply filter and validate filters.
    Given User Launch browser
    When User opens URL "https://www.amazon.in/"
    And I wait for 5 seconds
    And Click on SignIn Button to enter credentials
    And I wait for 5 seconds
    And Enter mobile number as "+919518970698" & click on continue
    And Enter password as "Sachin@007" & click on Sign In
    And I wait for 5 seconds
    Then Search phone as "iphone" & click "iphone 14 pro"
    And I wait for 5 seconds
    And Apply filter Sort by as "Price: Low to High"
    And I wait for 5 seconds
    And Validate filter should be "Price: Low to High"
    And I wait for 5 seconds
    And close the browser