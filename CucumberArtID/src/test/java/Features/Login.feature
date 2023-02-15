Feature: Application Login

  Scenario: HomePage default landing from Login to NetBanking Page by user1
    Given User is on Login to NetBanking Page
    When User Login with Username and Password
    Then HomePage is displayed
    And Cards are displayed


# Adding variables in the steps

  Scenario: HomePage default landing from Login to NetBanking Page by admin
    Given User is on Login to NetBanking Page
    When User Login with "admin" and "12345"
    Then HomePage is displayed
    And Cards are not displayed