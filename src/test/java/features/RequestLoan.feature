Feature: Request Loan

Scenario Outline: Verify that user is able to request loan
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User requests loan amount of "10000" with downpayment "1000"
Then Verify that user is able to request loan
