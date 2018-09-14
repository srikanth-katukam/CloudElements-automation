Feature: Common operations on dropbox

  Scenario: Ping the Element to confirm that the Hub element has a heartbeat
    Given I ping the element
    Then I verify ping data
      | endPoint |
      | dropbox  |

  Scenario: Retrieve the amount of storage available on your cloud service account
    Given I retrieve available storage
    Then I verify storage

  Scenario: Search a file name and folder name
    Given I perform a text search of file names and directory names
      | path       | text         |
      | /Documents | TextFile.txt |
    Then I verify file and folder path
      | path       | text         |
      | /Documents | TextFile.txt |



