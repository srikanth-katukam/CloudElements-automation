Feature: Folder CRUD operation on dropbox

  Scenario: Create a folder in dropbox
    Given I create a folder using below data
      | Path    |
      | /Images |
    And I verify the folder path
      | Path    |
      | /Images |

  Scenario: Delete a folder from dropbox
    Given I delete folder with below data
      | Path    |
      | /Images |
    And Verify folder is deleted

  Scenario: Delete a folder from dropbox associated with Id
    Given I delete folder with below data associated with Id
      | Path    |
      | /Images |
    And Verify folder is deleted

  Scenario: Retrieve folder meta data from dropbox
    Given I retrieve folder meta using below data
      | Path    |
      | /Images |
    And I verify the folder name
      | Path    |
      | /Images |

  Scenario: Retrieve folder meta data from dropbox associated with Id
    Given I retrieve folder meta using below data associated with Id
      | Path    |
      | /Images |
    And I verify the folder name
      | Path    |
      | /Images |