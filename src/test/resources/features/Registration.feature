@All
  Feature: Registration

    @Positive @Registration
    Scenario: Register with valid data
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with valid data
      And User clicks daftar button
      Then User is being redirected to verification page
      When User fills the verification kode
      And User click next button
      Then User is being redirected to registration successful
      And User is being redirected to homepage

    @Negative @Registration
      Scenario: Register with invalid email
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with invalid email
      And User clicks daftar button
      Then User got email invalid message

    @Negative @Registration
      Scenario: Register with invalid phone number
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with invalid phone number
      And User clicks daftar button
      Then User got phone number invalid message

    @Negative @Registration
      Scenario: Register with less than eight characters password
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with password less than eight characters
      And User clicks daftar button
      Then User got password must at least eight characters message

    @Negative @Registration
      Scenario: Register with already registered email
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with already registered email
      And User clicks daftar button
      Then User got email already exists message

    @Negative @Registration
      Scenario: Register with already registered phone number
      Given User is on homepage
      When User clicks masuk button
      Then User is being redirected to login page
      When User clicks daftar link text
      Then User is being redirected to registration page
      When User fills the registration form with already registered phone number
      And User clicks daftar button
      Then User got phone number already exists message

