Feature: Login
Scenario: Successful Login with Valid Credentials
Given User is on Home Page
When User enters UserName and Password
When User clicks on Go button
Then He can visit the practice page
Then A message is displayed

Scenario: Successful LogOut
When User LogOut from the Application
Then he cannot visit practice page





























