Feature: Exercise 2 (QAA-02) - Automation de API

  Scenario: As a user I want to test the POST operation on verb

  Scenario: As a user I want to test the POST operation on JsonPlaceHolder
    When I trigger POST call to create a new post
    Then I see the status code as 201
    And the response body should match "createSchema.json" file

  Scenario: As a user I want to test the POST operation on JsonPlaceHolder
    When I trigger POST call to create a new user
    Then I see the status code as 201
    And the response body should match "createSchema.json" file


  Scenario: As a user I want to get all Photographs
    When I trigger GET call on photography list
    Then I see the status code as 200

  Scenario: As a user I want to get all Albums
    When I trigger GET call on albums list
    Then I see the status code as 200

  Scenario: As a user I want to get all Comments
    When I trigger GET call on comments list
    Then I see the status code as 200

  Scenario: As a user I want to get all Users
    When I trigger GET call on users list
    Then I see the status code as 200