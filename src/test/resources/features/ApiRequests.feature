Feature: Booking

  Scenario: As a user I want to test the POST operation on authentication

    When I trigger POST call to Authenticate the user
    Then I see the status code as 200
    And the response body should match "authSchema.json" file

  Scenario: As a user I want to test the POST operation on bookings
    When I trigger POST call to create a new booking
    Then I see the status code as 200
    And the response body should match "bookingSchema.json" file

  Scenario: As a user I want to get all the bookings
    When I trigger GET call on bookings list
    Then I see the status code as 200

  Scenario: As a user I want to delete a booking
    When I trigger DELETE call on booking number 12
    Then I see the status code as 201

  Scenario: As a user I want to get a booking by id
    When I trigger GET call with the booking id 12
    Then I see the status code as 200


  Scenario: As a user I want to test the PUT operation to edit a booking
    When I trigger PUT call to update the booking 1
    Then I see the status code as 200
    And the response body should match "UpdateBookingSchema.json" file

