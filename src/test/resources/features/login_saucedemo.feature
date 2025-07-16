Feature: Login to sauce demo
As a user I should be able to login using valid credentials

# (New way)
  Scenario: User can login using valid username and password
  Given User is navigate to saucedemo website
  When User enters "standard_user" in the username field
  And  User enters "secret_sauce" in the password field
  And  User clicks on Login button
  Then user is able to verify the "Products" label is displayed

  
# (Old way)
#Test case 1:
#On saucedemo.com home page
#Enter username standard_user
#Enter password secret_sauce
#Verify Products label is displayed
# If you want to add comment in feature file do command / (mac) , control / (windows)