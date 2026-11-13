@FileUpload
Feature: File Upload Functionality

  Scenario: Verify user can upload a txt file and see the uploaded file name
    Given User navigates to "https://the-internet.herokuapp.com/"
    Then The Internet home page should be open
    When User clicks on 'File Upload' link
    Then File Upload page should be open
    When User selects "sample.txt" file to upload
    And User clicks on the 'Upload' button
    Then Uploaded file name "sample.txt" should be displayed