Feature: Google Search

  Scenario: Verify first search result contains searched text
    Given user is on the Google search page
    When user enters "Hello" in the Google search field
    And user applies the search
    Then first search result should contain "Hello"