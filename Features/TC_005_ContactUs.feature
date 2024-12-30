Feature: Contact Us Form

  Scenario: Verify Contact Us Form
    Given the user navigates to base page
    And the user clicks on contactus button
    When the msg GET IN TOUCH is visible
    And the user enters the contact details into below field
      | name    | testname           |
      | email   | testemail@test.com |
      | subject | testSubject        |
      | message | testmessage        |
    |path     |                    |
    And the user uploads the file
    Then the user click the submit button and clicks ok
    And the user is presented with successful submission msg
    And the user click home button and home page is displayed

