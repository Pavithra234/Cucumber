Feature: Adactin login functionality testing
This feature includes validation of username and password

Scenario: Login with valid username and password
Given user should be in adactin homepage 
When user enter the username in the username field
And user enter the password in the password field
And user clicks the login button 
And user select the location from dropdown
And user select the hotels from the dropdown
And user select the roomtype from the dropdown
And user select the number of rooms from the dropdown
And user enter the checkin the check in field
And user enter the checkout date in the checkout field
And user select the no of adults per room from the dropdown
And user select the no of children per room from the drop down
And user click on the search button

