@APIDemos
Feature: Testing the API Demos app

  In order to test the API Demo app
  As a user
  I want to able to test the toggle, checkbox and page navigation functionalities within the app

  @C1 @Smoke @Regression
  Scenario: To verify the user can successfully Turn on the switch preference
    Given user is on "prefpage"
    When user clicks "togbutton"
    Then toggle button is switched on

  @C2 @Smoke @Regression
  Scenario: To verify the user can successfully add the wifi connection
    Given user is on "wifipage"
    When user clicks "wifisetting"
    Then wifi connection is added successfully

  @C3 @Smoke @Regression
  Scenario: To verify the user can successfully check the child checkbox in the Preferences on Code page
    Given user is on "prefpage"
    When user clicks "childcheckbox"
    Then child checkbox is marked as turned on


