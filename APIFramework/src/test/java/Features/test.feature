Feature: f1

  Scenario: Add a new pet to the pet store
    Given Pet object that needs to be added to the store
    When I run "AddPetAPI" with "Post" request
    Then The call is successful with status code "available"
    And The "status" in the response body is "nkavailable"
    And The "id" in the response body is "20"


  Scenario Outline: Add a new pet to the pet store with Examples
    Given Pet object that needs to be added to the store with "<id>" "<name>" "<status>"
    When I run "AddPetAPI" with "Post" request
    Then The call is successful with status code "available"
#    And The "<status>" in the response body is "<status>"
#    And The "<id>" in the response body is "<id>"
    Examples:
      | id | name | status
      | 01 | nk1  | status1
      | 02 | nk2  | status2