Feature: login as librarian
  @showRecords
  Scenario: verify default values in Users page
    Given user is on the landing page
    When I login using "librarian12@library" and "AOYKYTMJ"
    When I click on "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |