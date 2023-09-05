@All
  Feature: Payment

    @Positive @Payment
      Scenario: Payment as a guest with valid data using Gopay number
      Given User is on homepage
      When User clicks Pulsa product menu
      Then User is being redirected to Isi Pulsa page
      When User fills phone number
      And User select the nominal credit
      Then User is being redirected to Payment page
      When User fills email
      And User selects Gopay payment method
      And User clicks Bayar Sekarang button
      Then User is being redirected to Pay with Gopay page

    @Positive @Payment
      Scenario: Payment as a user with valid data using Gopay number
      Given User is on homepage
      When User clicks Pulsa product menu
      Then User is being redirected to Isi Pulsa page
      When User fills phone number
      And User select the nominal credit
      Then User is being redirected to Payment page
      And User selects Gopay payment method
      And User clicks Bayar Sekarang button
      Then User is being redirected to Pay with Gopay page

    @Negative @Payment
      Scenario: Payment as a guest with invalid email
      Given User is on homepage
      When User clicks Pulsa product menu
      Then User is being redirected to Isi Pulsa page
      When User fills phone number
      And User select the nominal credit
      Then User is being redirected to Payment page
      When User fills with invalid email
      And User selects Gopay payment method
      And User clicks Bayar Sekarang button
      Then User got guest email invalid message

     @Negative @Payment
       Scenario: Payment as a guest with invalid changed number
       Given User is on homepage
       When User clicks Pulsa product menu
       Then User is being redirected to Isi Pulsa page
       When User fills phone number
       And User select the nominal credit
       Then User is being redirected to Payment page
       When User fills with valid email and invalid phone number
       And User selects Gopay payment method
       And User clicks Bayar Sekarang button
       Then User got guest phone number invalid message