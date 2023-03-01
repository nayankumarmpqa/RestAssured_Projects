Feature: Application Login Feature
  Scenario: Application Login from NetBanking page
    Given User in on NetBanking Page
    When User login with username and password
    Then Dashboard is displayed
    And Cards are displayed



  Scenario: Application Login with retail banking user
    Given User in on NetBanking Page
    When User login with "Nayan" and "1234"
    Then Dashboard is displayed
    And Cards are not displayed