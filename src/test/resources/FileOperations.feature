Feature: File CRUD operations on dropbox

  Scenario: Upload a file to dropbox
    Given I Upload files using below data
      | Name         | Description         | FilePath              | Tags | Overwrite |
      | TextFile.txt | Uploading text file | /Documents/TextFile.txt | Text | true      |
    Then I verify the file name
      | Name         |
      | TextFile.txt |

  Scenario: Retrieve a file from dropbox
    Given I retrieve files using below data
      | FilePath              |
      | /Documents/TextFile.txt |
    Then I verify the file name
      | Name            |
      | TextFile.txt |

  Scenario: Retrieve a file from dropbox with assoiated file Id
    Given I retrieve files using below data and file id
      | FilePath              |
      | /Documents/TextFile.txt |
    Then I verify the file name
      | Name            |
      | TextFile.txt |

  Scenario: Delete a file from dropbox with assoiated file Id
    Given I delete file with below data and file id
      | FilePath              |
      | /Documents/TextFile.txt |
    And Verify file is deleted

  Scenario: Delete a file from dropbox
    Given I delete file with below data
      | FilePath              |
      | /Documents/TextFile.txt |
    And Verify file is deleted

  Scenario: Retrieve file meta data from dropbox
    Given I retrieve file meta using below data
      | FilePath              |
      | /Documents/TextFile.txt |
    Then I verify the file name
      | Name            |
      | TextFile.txt |

  Scenario: Retrieve file meta data from dropbox with associated file Id
    Given I retrieve file meta using below data and file id
      | FilePath              |
      | /Documents/TextFile.txt |
    Then I verify the file name
      | Name            |
      | TextFile.txt |



