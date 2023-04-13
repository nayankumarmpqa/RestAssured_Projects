Feature: f1

  Scenario: Add a new pet to the pet store
    Given Pet object that needs to be added to the store
    When I run "AddPetAPI" with Post request
    Then The call is successful with status code "available"
    And The "status" in the response body is "nkavailable"

