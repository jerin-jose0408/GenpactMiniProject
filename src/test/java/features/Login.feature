Feature: Application Login

Scenario: Valid Home page login
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal
When User Logs into the application with "john" and "demo"
Then Home Page is navigated and user logged out


