Feature: User operations on dropbox

  Scenario: Get information about the user who is currently logged in
    Given I get user information
    Then I verify user information
      | login                       |name|
      | srikanth.katukam1@gmail.com |Srikanth Katukam|

