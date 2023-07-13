Feature: Validate broken images

  Scenario: Check for broken images on a webpage
    Given I am on the webpage "http://the-internet.herokuapp.com/broken_images"
    When I validate the images
    Then I should see the list of broken images