Feature: Validating Place APIs
  Scenario: Verify place is successfully added
    Given Add Place Payload
    When User call AddPlaceAPI wiht POST http request
    Then the API call is successfull with status code 200
    And status in response body is OK


  Scenario: Verify place is successfully added parameterized test case
    Given Add Place Payload
    When User call "AddPlaceAPI" wiht POST http request
    Then the API call is successfull with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

