Feature: Request Loan

Scenario: Verify that user is able to request loan
Given User launches portal with "john" and "demo"
When User requests loan amount of "10000" with downpayment "1000"
Then Verify that user is able to request loan
