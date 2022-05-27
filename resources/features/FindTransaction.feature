Feature: Find Transaction

Scenario: Verify that user is able to Find Transaction by Amount
Given User launches portal with "john" and "demo"
When User provides the amount as "1000" and clicks on Find
Then Verify find transaction is successful
