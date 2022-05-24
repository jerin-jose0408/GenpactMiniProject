Feature: Account Overview

Scenario Outline: Sum of balance matches the total
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User clicks on Accounts Overview
Then Verify the total matches the sum of balances
