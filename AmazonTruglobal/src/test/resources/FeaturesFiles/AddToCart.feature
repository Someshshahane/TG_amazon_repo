@Add-To-Cart
Feature: The product is successfully added to the cart.

  Scenario: Validate product addition to cart
    Given I am on the Home Page "https://www.amazon.in" of amazon Website
    When I search on Search tab
    And I search the "iphone"
    And Select iphone as iphone fifthteen pro max from searchlist
    Then Click on product details page
    And Check new window opened
    And Store the price in variable
    And Click on Add to Cart 
    And Check the popup Added to Cart
    Then Moving main Window
    And Click on Cart
    And Check the product added succesfully
    

  
