Feature: As a user I should be able to login with valid credentials

  Scenario: user should be able to login
    Given user is on the landing page
    When user enters a valid username
    And user enters a valid password
    Then user should able to login

    @parameterized
    Scenario: user should be able to login
      Given user is on the landing page
      When user enters username "student104@library"
      When user enters password "73ndoZd0"
      Then user should able to login

      @loginLibrarian
  Scenario: Login as librarian 12
    Given user is on the landing page
    When I enter username "librarian12@library"
    And I enter password 'AOYKYTMJ'
    And click the sign in button
    Then dashboard should be displayed
    And there should be 2827 users
#number can be whatever you have there
  @loginParameter
  Scenario: Login as librarian same line
    Given user is on the landing page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then dashboard should be displayed
#number can be whatever you have there
