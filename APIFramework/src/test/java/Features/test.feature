Feature: f1

  @AddNewPetTag
  Scenario: Add a new pet to the pet store
    Given Pet object that needs to be added to the store
    When I run "AddPetAPI" with "Post" request
    Then The call is successful with status code 200
    And The "status" in the response body is "nkavailable"
    And The "id" in the response body is "20"

@AddNewPetTag2
  Scenario Outline: Add a new pet to the pet store with Examples
    Given Pet object that needs to be added to the store with "<id>" "<name>" "<status>"
    When I run "AddPetAPI" with "Post" request
    Then The call is successful with status code 200
    And verify created petid using "GetPetByIdAPI"
#    And The "<status>" in the response body is "<status>"
#    And The "<id>" in the response body is "<id>"
    Examples:
      | id | name | status
      | 01 | nk1  | abc
   #   | 02 | nk2  | def

@DeletNewlyAddedPetTag
  Scenario: Verify Delete the newly added pet
    Given Delete Pet payload object that is needed is ready
    When I run "DeletePetAPI" with "Delete" request
    Then The call is successful with status code 200
    And The "code" in the response body is "200"
