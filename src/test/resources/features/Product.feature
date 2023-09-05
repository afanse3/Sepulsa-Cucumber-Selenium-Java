@All
  Feature: Product

    @Positive @Product
      Scenario: Buy Pulsa product
      Given User is on homepage
      When User clicks Pulsa product menu
      Then User is being redirected to Isi Pulsa page
      When User fills phone number
      And User select the nominal credit
      Then User is being redirected to Payment page

    @Negative @Product
      Scenario: Buy pulsa product with invalid number
      Given User is on homepage
      When User clicks Pulsa product menu
      Then User is being redirected to Isi Pulsa page
      When User fills invalid phone number
      Then User wont see credit selection menu
