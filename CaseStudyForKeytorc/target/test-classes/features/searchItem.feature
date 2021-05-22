
Feature: search, add to favorite list and remove from favorite list
  @hepsiburada
  Scenario: login search and favorite list function
    Given the user is on the main page
    When log in with valid credentials
    When the user enter "samsung" information
    Then the user verifies that he sees "samsung" items in listing
    And select second page
    Then second page should be shown
    And add third item to favorites
    Then the selected item should be display
    And remove item from favorite list
    Then item should not be in favorite list