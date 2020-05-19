@Completed @Accepted @Api @EnableTrackingHeader @St @It @At
Feature: Demoing use of API testing by validating actuator endpoints

  Background: The api url
    Given I visit "${api.url}"

  Scenario: 001 - Verify the health of the api
    Given I send the following headers:
      | name   | value            |
      | Accept | application/json |
    When I request GET to "/manage/health"
    Then response code should be 200
    Then response content path "status" should be "UP"

  Scenario: 002 - Verify the info endpoint is enabled
    Given I send the following headers:
      | name   | value            |
      | Accept | application/json |
    When I request GET to "/manage/info"
    Then response code should be 200

  Scenario: 003 - Verify the prometheus endpoint is enabled
    When I request GET to "/manage/prometheus"
    Then response code should be 200