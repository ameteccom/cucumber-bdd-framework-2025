
@smoke @crater
Feature: User Access Management
  As a user I want to login to my crater Application

Background:
  Given User is navigated to Crater Login page

Rule: Valid Login
  The Application should allow valid users to log in

  
  Scenario: User should be able to login with valid credentials
  When User enters valid username and valid password
  And User clicks on crater application Login button
  Then User should be logged in successfully


#1.	Navigate to the login page.
#2.	Enter a valid email address “entityadmin@primetechschool.com”.
#3.	Enter a valid password “primetech@school”.
#4.	Click on the Login button.
#5.	Verify the user is redirected to the dashboard.
#6.	Verify a success message is displayed.


#Scenario # 2 --- Negative Scenario
# Cucumber reuses the steps that are already implemented
# if there are same two steps
# cucumber only generates one step definition and reuses that step definition between that two steps


  Scenario:User should not be able to login with invalid email and invalid password
  When User enters invalid username and invalid password
  And User clicks on crater application Login button
  Then User should see an error message "These credentials do not match our records." displayed
  And User should not be logged in
