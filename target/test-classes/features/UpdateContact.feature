Feature: Update Contact Info

Scenario Outline: Verify that user is able to change phone no
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User changes contact no to "310-447-4123"
Then Verify contact details is updated
