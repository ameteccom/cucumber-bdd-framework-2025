@crater @add-item
Feature: Add Item
  As a user
  I want to add item to the list of item
  so I can see it as part of the list

  Scenario: Successfully add a new item
    Given User is logged in successfully
    When User clicks on Add Item button
    And User enters the item name
    And User enters the item description
    And User enters the item price "12.99"
    And User enters the item unit "grams"
    And User clicks on the Save Item button
    Then Item should be listed in the item table








#1.	Navigate to the Items page. (you are able to login
#2.	Click on the Add Item button.
#3.	Enter the item name.
#4.	Enter the item description.
#5.	Enter the item price “12.99.
#6.	Select the item unit “grams”
#7.	Click the Save Item button.
#8.	Verify that the new item is listed in the items table.
