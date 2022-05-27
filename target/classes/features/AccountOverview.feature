Feature: Account Overview

Scenario: Sum of balance matches the total
Given User launches portal with "john" and "demo"
When User clicks on Accounts Overview
Then Verify the total matches the sum of balances
