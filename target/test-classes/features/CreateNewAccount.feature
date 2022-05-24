Feature: Open New Account

Scenario Outline: User creates a new Account
Given User launches "https://parabank.parasoft.com/parabank/index.htm" portal with "john" and "demo"
When User clicks on Open New Account with <type> and <index> 
Then Verify a new account is created

Examples:
|type		|index	|
|CHECKING	|0		|
|SAVINGS	|0		|