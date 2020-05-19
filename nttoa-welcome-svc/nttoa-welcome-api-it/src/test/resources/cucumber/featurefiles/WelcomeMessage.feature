@Completed @Accepted @Api @EnableTrackingHeader @It @St
Feature: As a user, I Want to get Welcome response
  Background: The api url
    Given I visit "${api.url}"
    And I send the following headers:
      | name          | value                      |
      | Accept        | application/json           |
      | Authorization | Basic bmFwYW1hbjpuYXBhc3Az |

  Scenario: 001 - welcome to user
    And I send the following form parameters:
      | name               | value                 |
      | name               | Prakash                 |
    When I request GET to "/welcome/Prakash"
    Then response code should be 200
    And response content should contain "Welcome Prakash !!!"
