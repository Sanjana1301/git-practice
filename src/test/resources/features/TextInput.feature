@TextInput
Feature: Text Input Functionality

  Scenario: Verify button text updates with entered random text
    Given User navigates to "http://uitestingplayground.com/"
    When User clicks on 'Text Input' link
    Then Text Input page should be open
    When User enters random text into the text field
    And User clicks the updating button
    Then Text displayed on button should be the same as entered