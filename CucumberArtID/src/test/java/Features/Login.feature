Feature: Application Login

  Scenario: HomePage default landing from Login to NetBanking Page
    Given User is on Login to NetBanking Page
    When User Login with Username and Password
    Then HomePage is displayed
    And Cards are displayed