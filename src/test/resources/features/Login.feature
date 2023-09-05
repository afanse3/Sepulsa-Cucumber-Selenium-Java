@All
  Feature: Login

    @Positive @Login
      Scenario: Login with valid phone number and password
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User fills the valid phone number and password
      Then User is being redirected to homepage

    @Positive @Login
      Scenario: Login with valid email and password
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User fills the valid email and password
      Then User is being redirected to homepage

    @Negative @Login
    Scenario: Login with invalid credential
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User fills with invalid credentials
      Then User got login error message


