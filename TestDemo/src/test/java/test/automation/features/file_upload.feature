Feature: File Upload

  Scenario: Upload a file
    Given I am on the webpage "http://the-internet.herokuapp.com/upload"
    When I upload the file with path "/Users/nagarajs/Downloads/Arh-avatar.jpeg"
    Then I should see a success message
