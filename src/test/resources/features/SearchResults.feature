
Feature: Search Functionality on user page
    @wip
    Scenario: Table columns names
    Given user is on the landing page
    When I login using "librarian12@library" and "AOYKYTMJ"
    And I click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |