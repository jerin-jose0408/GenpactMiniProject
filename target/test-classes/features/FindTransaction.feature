Feature: Find Transaction

Scenario Outline: Verify that user is able to Find Transaction by Amount
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User provides the amount as "1000" and clicks on Find
Then Verify find transaction is successful
